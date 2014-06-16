import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Table extends JFrame{ //extends JFrame{
    
    private Deck deck; //deck to draw from
    private Discard discard; //discarded cards (action,goals)
    private Card goal;
    private Card goal2; //for Double Agenda
    private ArrayList<Card> rules;
    private ArrayList<Player> players;

    private int turn;

    private boolean doubleAgenda;
    private boolean inflation;
    private boolean firstPlayRandom;
    private boolean noHandBonus;
    private boolean poorBonus;
    private boolean richBonus;
    private boolean partyBonus;
    private boolean getOnWithIt;
    private boolean silverLining;
    private boolean needPotato;

    private int draw;
    private int play;

    String eol = System.getProperty("line.separator"); //in order to differentiate for different OSes


    public Table(){
        //Gui stuff
        super("Fluxx, the Game");
        setBounds(0,0,720,720);
        JPanel pane = new JPanel();

        Container container = this.getContentPane();
        container.setBackground(Color.WHITE);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(pane);
        //pane.add(playButton);
        setVisible(true);

        turn = 0;

        rules = new ArrayList<Card>();
        goal = null;
        goal2 = null;
        inflation = false;
        draw = play = 1;

        deck = new Deck();
        discard = new Discard();
        players = new ArrayList<Player>();
    }

    
    public Deck getDeck(){
        return deck;
    }

    public String getGoal(){
        return goal.getName();
    }

    public String getRules(){
        String str = "";
        for(Card r: rules){
            str += r.getName() + ", ";
        }
        return str;
    }

    public Discard getDiscard(){
        return discard;
    }

    public void addRule(Card r){
        rules.add(r);
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void setGoal(Card g) {
        if (g.getType().equals("Goal"))
            goal = g;
        else
            throw new IllegalArgumentException("The Card must be a Goal");
    } //change Goal

    public void setGoal(Card g, boolean first){ //Double Agenda
        if(g.getType().equals("Goal")) {

            boolean isDoubleAgenda = false;
            for (int i = 0; i < rules.size(); i++) { //check for double agenda
                if (rules.get(i).getName().equals(deck.DOUBLEAGENDA)) {
                    isDoubleAgenda = true;
                }
            }

            if (isDoubleAgenda) {
                if (first)
                    goal = g;
                else
                    goal2 = g;
            }
        }else
            throw new IllegalArgumentException("The Card must be a Goal");
    } //Double Agenda



    public void warEffect(Player p1, Player p2){
        boolean hasPeace = (p1.hasCard(deck.PEACE) != -1);
        boolean hasWar = (p1.hasCard(deck.WAR) != -1);

        if(hasPeace == true && hasWar == true){
            JOptionPane.showMessageDialog(this, "Because you're Peaceful, you give War to someone else.", "World Peace", JOptionPane.INFORMATION_MESSAGE);
            p1.givePlayerTable(p2, deck.WAR);
        }
    }

    public void taxesEffect(Player p1){
        boolean hasTaxes = (p1.hasCard(deck.TAXES) != -1);
        boolean hasMoney = (p1.hasCard(deck.MONEY) != -1);

        if(hasTaxes == true && hasMoney == true){
            p1.discard(discard, p1.hasCard(deck.TAXES));
            p1.discard(discard, p1.hasCard(deck.MONEY));
        }
    }

    public void potatoEffect(Player p1, Player p2){
        p1.givePlayerTable(p2, deck.POTATO);
    }

    public void deathEffect(Player p, Card c){
        if(p.getOnTable().size() == 1) {
            int n = JOptionPane.showConfirmDialog(this, "Would you like to discard Death?", "Death Beckons", JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION)
                p.discard(discard, c);
        }else{
            ArrayList<Card> possibilities1 = new ArrayList<Card>(p.size() - 1);
            for(int i = 0; i < p.size(); i ++){
                if(p.hasCard(deck.DEATH) != -1){
                    possibilities1.add(p.getHand().get(i));
                }
            }

            Card[]possibilities = new Card[p.size() - 1];
            for(int i = 0; i < possibilities1.size(); i ++){
                possibilities[i] = possibilities1.get(i);

            }

            Card ca = (Card)JOptionPane.showInputDialog(this, "Which card would you like to discard?", "Death Beckons", JOptionPane.INFORMATION_MESSAGE, null, possibilities, possibilities[0]);

            p.discard(discard, ca);
        }
    }

    public void jackpot(Player p){
        p.discard(discard, deck.JACKPOT);
        if(inflation)
            p.draw(deck, 4);
        else
            p.draw(deck, 3);
    }

    public void discardAndDraw(Player p){
        p.discard(discard, deck.DISCARDANDDRAW);
        int cards = p.size();
        while(p.size() > 0){
            p.discard(discard, 0);
        }
        p.draw(deck, cards);

    }

/*
    public void drawTwoUseEm(Player p){
        p.discard(discard, deck.DRAW2USE2);
        ArrayList<Card> setAside = p.getHand();

        for(int i = 0; i < p.size(); i ++){
            setAside.add(p.remove(0));
        }

        if(inflation == true){
            p.draw(deck, 3);
            p.addRemainingPlays(3);
        }else{
            p.draw(deck, 2);
            p.addRemainingPlays(2);
        }

        while(setAside.size() > 0) {
            p.addToHand(setAside.remove(0));
        }
    }

    public void drawThreeUseTwo(Player p, Card c){
        p.discard(discard, deck.DRAW3USE2);
        ArrayList<Card> setAside = p.getHand();

        for(int i = 0; i < p.size(); i ++){
            setAside.add(p.remove(0));
        }

        if(inflation == true){
            p.draw(deck, 4);
            p.addRemainingPlays(3);
            p.discard(discard, c);
        }else{
            p.draw(deck, 3);
            p.addRemainingPlays(2);
            p.discard(discard, c);
        }

        while(setAside.size() > 0){
            p.addToHand(setAside.remove(0));
        }
    }

    public void everybodyGetsOne(Player p, boolean first){
        p.discard(discard, deck.EVERY1);
        int num = players.size();

        ArrayList<Card> setAside = p.getHand();
        for(int i = 0; i < p.size(); i ++){
            setAside.add(p.remove(0));
        }

        p.draw(deck, num);

        for(int i = 0; i < num; i ++) {
            if (first) {
                p.givePlayerCard(p2, p.remove(0));
                while (setAside.size() > 0) {
                    p.addToHand(setAside.remove(0));
                }
            } else{
                p.givePlayerCard(p2, p.remove(1));
                while (setAside.size() > 0) {
                    p.addToHand(setAside.remove(0));
                }
            }
        }
    }
*/

    public void exchangeKeepers(Player p1, Player p2, Card c1, Card c2){
        p1.discard(discard, deck.EXCHANGE);
        if(p1.getOnTable().size() == 0 || p2.getOnTable().size() == 0){
            return;
        }
        if(c1.getType() != "Keeper" || c2.getType() != "Keeper" || p1.hasCard(c1) == -1 || p2.hasCard(c2) == -1){
            return;
        }
        p1.givePlayerTable(p2, c1);
        p2.givePlayerTable(p1, c2);
    }

    public void letsDoThatAgain(Discard discard, Player player){
        player.discard(discard, deck.DOAGAIN);
        int num = 0;
        Card[] available;
        for(int i = 0; i < discard.size(); i ++){
            if(discard.get(i).getType() == "New Rule" || discard.get(i).getType() == "Action")
                num ++;
        }

        available = new Card[num];
        int b = 0;
        for(int a = 0; a < discard.size(); a ++){
            if(discard.get(a).getType() == "New Rule" || discard.get(a).getType() == "Action") {
                available[b] = discard.get(a);
                b++;
            }
        }

        Card c = (Card)JOptionPane.showInputDialog(this, "Which card would you like to use again?",
                                                    "Let's Do That Again!", JOptionPane.PLAIN_MESSAGE, null,
                                                    available, available[0]);
        play(player, c);
    }

    private void swapArrayList(ArrayList<Card> list1, ArrayList<Card> list2){
        ArrayList<Card> temp = list1;
        list1 = list2;
        list1 = temp;
    } //helper for rotateHands

    public void rotateHands(boolean right, int numPlayers, Player p){
        p.discard(discard, deck.ROTATE);
        if(numPlayers == 2){
            swapArrayList(players.get(0).getHand(), players.get(1).getHand());
            return;
        }

        if(right) {
            for (int i = 0; i < numPlayers - 1; i++) {
                swapArrayList(players.get(i).getHand(), players.get(i + 1).getHand());
            }
            swapArrayList(players.get(numPlayers - 1).getHand(), players.get(0).getHand());
        }else{
            for(int i = 0; i < numPlayers - 1; i ++){
                swapArrayList(players.get(i + 1).getHand(), players.get(i).getHand());
            }
            swapArrayList(players.get(0).getHand(), players.get(numPlayers - 1).getHand());
        }
    }

    public void rulesReset(Player p){
        p.discard(discard, deck.RESET);
        rules = new ArrayList<Card>();
    }

    //public void takeAnotherTurn(Player p){
    //   p.discard(discard, deck.TURN2);
    //    boolean turn2 = false;
    //    while(p.getRemainingPlays() == 0 && turn2 == true){
    //        p.draw(deck,draw);
    //        p.addRemainingPlays(play);
    //        turn2 = true;
    //    }
    //}

    private ArrayList<Player> selectAllButOne(ArrayList<Player> al, Player o){ //assume that o is in al
        ArrayList<Player> retAL = new ArrayList<Player>(al.size() - 1);
        for(int i = 0; i < al.size(); i ++){
            if(!al.get(i).equals(o))
                retAL.add(al.get(i));
        }
        return retAL;
    }

    public void taxation(Player p){
        p.discard(discard, deck.TAXATION);
        ArrayList<Player> playersWO = selectAllButOne(players, p);
        if(inflation){
            for(int i = 0; i < playersWO.size(); i ++){
                playersWO.get(i).givePlayerCard(p, playersWO.get(i).remove(0));
                playersWO.get(i).givePlayerCard(p, playersWO.get(i).remove(0));
            }
        }else {
            for (int i = 0; i < playersWO.size(); i++) {
                playersWO.get(i).givePlayerCard(p, playersWO.get(i).remove(0));
            }
        }
    }

    public void tradeHands(Player p1, Player p2){
        p1.discard(discard, deck.TRADEHANDS);
        swapArrayList(p1.getHand(), p2.getHand());
    }

    public void trashNewRule(Player p){
        p.discard(discard, deck.TRASHNR);
        Card[]list = new Card[rules.size()];

        for(int i = 0; i < rules.size(); i ++){
            list[i] = rules.get(i);
        }

        Card c = (Card)JOptionPane.showInputDialog(this,"Choose a New Rule to discard:",
                                                    "Trash a New Rule",JOptionPane.PLAIN_MESSAGE,
                                                    null, list, list[0]);
        rules.remove(c);
    }

    //public void useWhatYouTake(Player p1, Player p2){
    //    p1.discard(discard, deck.USETAKE);
    //    p1.play(p2.getHand().get(0));
    //}

    public void creeperSweeper(Player p1){
        p1.discard(discard, deck.SWEEPER);

        for(int i = 0; i < players.size(); i ++){
            if(players.get(i).hasCard(deck.WAR) == -1 || players.get(i).hasCard(deck.DEATH) == -1 ||
               players.get(i).hasCard(deck.TAXES) == -1 || players.get(i).hasCard(deck.POTATO) == -1){
                players.get(i).getOnTable().remove(deck.WAR);
                players.get(i).getOnTable().remove(deck.POTATO);
                players.get(i).getOnTable().remove(deck.DEATH);
                players.get(i).getOnTable().remove(deck.TAXES);
            }
        }
    }

    public void trashSomething(Player p1, Player p2) {
        p1.discard(discard, deck.TRASHSOMETHING);
        ArrayList<Card> stuff = new ArrayList<Card>();
        for (int i = 0; i < p1.getOnTable().size(); i++) {
            stuff.add(p1.getOnTable().get(i));
        }

        for (int i = 0; i < p2.getOnTable().size(); i++) {
            stuff.add(p2.getOnTable().get(i));
        }

        Card[] options = new Card[stuff.size()];
        for (int i = 0; i < stuff.size(); i++) {
            options[i] = stuff.get(i);
        }

        Card c = (Card) JOptionPane.showInputDialog(this, "Choose a card to trash:", "Trash Something",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (p1.getOnTable().contains(c))
            p1.getOnTable().remove(c);
        else if (p2.getOnTable().contains(c))
            p2.getOnTable().remove(c);
    }

    public void stealSomething(Player p1, Player p2){
        p1.discard(discard, deck.STEALSOMETHING);
        Card[]options = new Card[p2.getOnTable().size()];

        for(int i = 0; i < p2.getOnTable().size(); i ++) {
            options[i] = p2.getOnTable().get(i);
        }

        Card c = (Card)JOptionPane.showInputDialog(this, "Choose a card to steal:", "Steal Something",
                                                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        p2.givePlayerTable(p1, c);
    }

    public void mixItAllUp(Player p){
        p.discard(discard, deck.MIX);
        ArrayList<Card> mixer = new ArrayList<Card>();
        for(int i = 0; i < players.size(); i ++){
            for(int a = 0; a < players.get(i).getOnTable().size(); a ++){
                mixer.add(players.get(i).getOnTable().remove(a));
            }
        }

        Collections.shuffle(mixer);
        int counter = 0;
        while(mixer.size() > 0){
            if(counter > players.size())
                counter = 0;
            players.get(counter).getOnTable().add(mixer.remove(0));
            counter ++;
        }
    }


    public void draw2(Player p){
        rules.remove(deck.DRAW3);
        rules.remove(deck.DRAW4);
        rules.remove(deck.DRAW5);
        rules.add(p.remove(deck.DRAW2));
        int prevDraw = draw;
        draw = 2;
        if(prevDraw < draw){
            p.draw(deck, draw - prevDraw);
        }
    }
    public void draw3(Player p){
        rules.remove(deck.DRAW2);
        rules.remove(deck.DRAW4);
        rules.remove(deck.DRAW5);
        rules.add(p.remove(deck.DRAW3));
        int prevDraw = draw;
        draw = 3;
        if(prevDraw < draw){
            p.draw(deck, draw - prevDraw);
        }
    }
    public void draw4(Player p){
        rules.remove(deck.DRAW3);
        rules.remove(deck.DRAW2);
        rules.remove(deck.DRAW5);
        rules.add(p.remove(deck.DRAW4));
        int prevDraw = draw;
        draw = 4;
        if(prevDraw < draw){
            p.draw(deck, draw - prevDraw);
        }
    }
    public void draw5(Player p){
        rules.remove(deck.DRAW3);
        rules.remove(deck.DRAW4);
        rules.remove(deck.DRAW2);
        rules.add(p.remove(deck.DRAW5));
        int prevDraw = draw;
        draw = 5;
        if(prevDraw < draw){
            p.draw(deck, draw - prevDraw);
        }
    }

    public void play2(Player p){
        rules.remove(deck.PLAY3);
        rules.remove(deck.PLAY4);
        rules.remove(deck.PLAYALL);
        rules.add(p.remove(deck.PLAY2));
        play = 2;
    }
    public void play3(Player p){
        rules.remove(deck.PLAY2);
        rules.remove(deck.PLAY4);
        rules.remove(deck.PLAYALL);
        rules.add(p.remove(deck.PLAY3));
        play = 3;
    }
    public void play4(Player p){
        rules.remove(deck.PLAY2);
        rules.remove(deck.PLAY3);
        rules.remove(deck.PLAYALL);
        rules.add(p.remove(deck.PLAY4));
        play = 4;
    }
    public void playAll(Player p){
        rules.remove(deck.PLAY2);
        rules.remove(deck.PLAY3);
        rules.remove(deck.PLAY4);
        rules.add(p.remove(deck.PLAYALL));
        play = Integer.MAX_VALUE;
    }

    public void doubleAgenda(Player p){
        rules.add(p.remove(deck.DOUBLEAGENDA));
    }

    public void firstPlayRandom(Player p){
        rules.add(p.remove(deck.FPRANDOM));
    }

    public void noHandBonus(Player p){
        rules.add(p.remove(deck.NOHAND));
    }

    public void poorBonus(Player p){
        rules.add(p.remove(deck.POOR));
    }

    public void richBonus(Player p){
        rules.add(p.remove(deck.RICH));
    }

    public void partyBonus(Player p){
        rules.add(p.remove(deck.PARTYBONUS));
    }

    public void getOnWithIt(Player p){
        rules.add(p.remove(deck.GETONWITHIT));
    }

    public void silverLining(Player p){
        rules.add(p.remove(deck.SILVER));
    }

    public void needPotato(Player p){
        rules.add(p.remove(deck.NEEDPOTATO));
    }

    public void goalChecker(){

        if(goal.equals(deck.ALLLOVE) || goal2.equals(deck.ALLLOVE)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.LOVE) && players.get(i).getOnTable().size() == 1 ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.APPLIANCES) || goal2.equals(deck.APPLIANCES)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.TOASTER) && players.get(i).getOnTable().contains(deck.TELEVISION)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                            !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false)){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }
        }
        if(goal.equals(deck.BAKED) || goal2.equals(deck.BAKED)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.COOKIES) && players.get(i).getOnTable().contains(deck.BREAD)
                && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false)){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.BEDTIME) || goal2.equals(deck.BEDTIME)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.SLEEP) && players.get(i).getOnTable().contains(deck.DREAMS)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.CHOCOLATECOOKIES) || goal2.equals(deck.CHOCOLATECOOKIES)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.CHOCOLATE) && players.get(i).getOnTable().contains(deck.COOKIES)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.CHOCOLATEMILK) || goal2.equals(deck.CHOCOLATEMILK)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.CHOCOLATE) && players.get(i).getOnTable().contains(deck.MILK)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.DEATHBYCHOCOLATE) || goal2.equals(deck.DEATHBYCHOCOLATE)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.DEATH) && players.get(i).getOnTable().contains(deck.CHOCOLATE)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.DREAMLAND) || goal2.equals(deck.DREAMLAND)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.DREAMS) && players.get(i).getOnTable().contains(deck.COSMOS)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.HEARTSANDMINDS) || goal2.equals(deck.HEARTSANDMINDS)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.LOVE) && players.get(i).getOnTable().contains(deck.BRAIN)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.HIPPYISM) || goal2.equals(deck.HIPPYISM)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.LOVE) && players.get(i).getOnTable().contains(deck.PEACE)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.MILKANDCOOKIES) || goal2.equals(deck.MILKANDCOOKIES)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.MILK) && players.get(i).getOnTable().contains(deck.COOKIES)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.NIGHTANDDAY) || goal2.equals(deck.NIGHTANDDAY)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.MOON) && players.get(i).getOnTable().contains(deck.SUN)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.ROCKETTOMOON) || goal2.equals(deck.ROCKETTOMOON)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.ROCKET) && players.get(i).getOnTable().contains(deck.MOON)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.SQUISHYCHOCOLATE) || goal2.equals(deck.SQUISHYCHOCOLATE)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.SUN) && players.get(i).getOnTable().contains(deck.CHOCOLATE)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.TIMEISMONEY) || goal2.equals(deck.TIMEISMONEY)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.TIME) && players.get(i).getOnTable().contains(deck.MONEY)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.TOAST) || goal2.equals(deck.TOAST)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.BREAD) && players.get(i).getOnTable().contains(deck.TOASTER)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.WARDEATH) || goal2.equals(deck.WARDEATH)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.WAR) && players.get(i).getOnTable().contains(deck.DEATH)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.MINDSEYE) || goal2.equals(deck.MINDSEYE)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.EYE) && players.get(i).getOnTable().contains(deck.BRAIN)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.DOUGH) || goal2.equals(deck.DOUGH)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.MONEY) && players.get(i).getOnTable().contains(deck.BREAD)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.ALLCERTAIN) || goal2.equals(deck.ALLCERTAIN)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.TAXES) && players.get(i).getOnTable().contains(deck.DEATH)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.INTERSTELLAR) || goal2.equals(deck.INTERSTELLAR)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.ROCKET) && players.get(i).getOnTable().contains(deck.COSMOS)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.STARGAZING) || goal2.equals(deck.STARGAZING)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.EYE) && players.get(i).getOnTable().contains(deck.COSMOS)
                        && ((!players.get(i).getOnTable().contains(deck.WAR) || !players.get(i).getOnTable().contains(deck.DEATH) ||
                        !players.get(i).getOnTable().contains(deck.POTATO) || !players.get(i).getOnTable().contains(deck.TAXES)) && silverLining == false) ){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }
        if(goal.equals(deck.PARTYSNACKS) || goal2.equals(deck.PARTYSNACKS)){
            for(int i = 0; i < players.size(); i ++){
                if(players.get(i).getOnTable().contains(deck.PARTY) && (players.get(i).getOnTable().contains(deck.COOKIES) || players.get(i).getOnTable().contains(deck.CHOCOLATE) || players.get(i).getOnTable().contains(deck.BREAD)) &&
                        (!players.get(i).getOnTable().contains(deck.WAR) && !players.get(i).getOnTable().contains(deck.TAXES) && !players.get(i).getOnTable().contains(deck.POTATO) && !players.get(i).getOnTable().contains(deck.DEATH) && silverLining == false)){
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1 + " wins!"));
                    System.exit(0);
                }
            }

        }

    }

    public int numDraws(){
        if(inflation)
            return draw + 1;
        else
            return draw;
    }

    public int numPlays(){
        if(inflation)
            return play + 1;
        else
            return play;
    }

    public void changeTurns(){
        turn ++;
        if(turn == players.size())
            turn = 0;
    }


    public void play(Player p, Card c) {
        if (c.getType().equals("Action")) {
            if(c.equals(deck.JACKPOT))
                jackpot(p);
            if(c.equals(deck.DISCARDANDDRAW))
                discardAndDraw(p);
            if(c.equals(deck.EXCHANGE)){
                if(players.get(0).getOnTable().size() == 0 || players.get(1).getOnTable().size() == 0){
                    p.addRemainingPlays(1);
                    return;
                }
                Card[]one = new Card[players.get(0).getOnTable().size()];
                Card[]two = new Card[players.get(1).getOnTable().size()];

                if(players.get(0).equals(p)) {
                    Card c1 = (Card) JOptionPane.showInputDialog(this, "Pick one of your Keepers to exchange", "Exchange Keepers", JOptionPane.PLAIN_MESSAGE, null, one, one[0]);
                    Card c2 = (Card) JOptionPane.showInputDialog(this, "Pick one of your opponent's Keepers to exchange", "Exchange Keepers", JOptionPane.PLAIN_MESSAGE, null, two, two[0]);
                    exchangeKeepers(p, players.get(1), c1, c2);
                }else if (players.get(1).equals(p)) {
                        Card c2 = (Card) JOptionPane.showInputDialog(this, "Pick one of your Keepers to exchange", "Exchange Keepers", JOptionPane.PLAIN_MESSAGE, null, one, one[0]);
                        Card c1 = (Card) JOptionPane.showInputDialog(this, "Pick one of your opponent's Keepers to exchange", "Exchange Keepers", JOptionPane.PLAIN_MESSAGE, null, two, two[0]);
                        exchangeKeepers(p, players.get(0), c1, c2);
                }
            }
            if(c.equals(deck.DOAGAIN))
                letsDoThatAgain(discard,p);
            if(c.equals(deck.ROTATE)) {
                Object[] options = {"Left", "Right"};
                int n = JOptionPane.showOptionDialog(this, "In which direction would you like to rotate hands?", "Rotate Hands", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Right");
                boolean right = (n == JOptionPane.YES_OPTION);
                if (right)
                    rotateHands(right, players.size(), p);
                else
                    rotateHands(!right, players.size(), p);
            }
            if(c.equals(deck.RESET))
                rulesReset(p);
            if(c.equals(deck.TAXATION))
                taxation(p);
            if(c.equals(deck.TRADEHANDS)) {
                ArrayList<Player> temp1 = selectAllButOne(players, p);
                Player[] temp = new Player[temp1.size()];
                for (int i = 0; i < temp1.size(); i++) {
                    temp[i] = temp1.get(i);
                }
                Player ca = (Player) JOptionPane.showInputDialog(this, "Pick a player to trade hands with", "Trade Hands",JOptionPane.PLAIN_MESSAGE, null, temp, temp[0]);
                tradeHands(p, ca);
            }
            if(c.equals(deck.TRASHNR))
                trashNewRule(p);
            if(c.equals(deck.TRASHSOMETHING)) {
                Player[] temp = new Player[players.size()];
                for (int i = 0; i < players.size(); i++) {
                    temp[i] = players.get(i);
                }
                Player ca = (Player) JOptionPane.showInputDialog(this, "Pick a player to trash something from", "Trash Something", JOptionPane.PLAIN_MESSAGE, null, temp, temp[0]);
                trashSomething(p, ca);
            }
            if(c.equals(deck.STEALSOMETHING)){
                ArrayList<Player> temp1 = selectAllButOne(players, p);
                Player[] temp = new Player[temp1.size()];
                for (int i = 0; i < temp1.size(); i++) {
                    temp[i] = temp1.get(i);
                }
                Player ca = (Player) JOptionPane.showInputDialog(this, "Pick a player to steal something from", "Steal Something",JOptionPane.PLAIN_MESSAGE, null, temp, temp[0]);
                stealSomething(p, ca);
            }
            if(c.equals(deck.MIX))
                mixItAllUp(p);
        }
        if (c.getType().equals("NewRule")) {
            if (c.equals(deck.DRAW2))
                draw2(p);
            if (c.equals(deck.DRAW3))
                draw3(p);
            if (c.equals(deck.DRAW4))
                draw4(p);
            if (c.equals(deck.DRAW5))
                draw5(p);

            if(c.equals(deck.PLAY2))
                play2(p);
            if(c.equals(deck.PLAY3))
                play3(p);
            if(c.equals(deck.PLAY4))
                play4(p);
            if(c.equals(deck.PLAYALL))
                playAll(p);

            if(c.equals(deck.DOUBLEAGENDA))
                doubleAgenda(p);
            if(c.equals(deck.FPRANDOM))
                firstPlayRandom(p);
            if(c.equals(deck.NOHAND))
                noHandBonus(p);
            if(c.equals(deck.POOR))
                poorBonus(p);
            if(c.equals(deck.RICH))
                richBonus(p);
            if(c.equals(deck.PARTYBONUS))
                partyBonus(p);
            if(c.equals(deck.GETONWITHIT))
                getOnWithIt(p);
            if(c.equals(deck.SILVER))
                silverLining(p);
            if(c.equals(deck.NEEDPOTATO))
                needPotato(p);

        }
        if (c.getType().equals("Goal")){
            if(doubleAgenda){
                String[]options = {goal.getName(), goal2.getName()};
                int n = JOptionPane.showOptionDialog(this, "Which Goal would you like to discard?", "New Goal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                boolean left = n == JOptionPane.YES_OPTION;
                if(left)
                    goal = c;
                else
                    goal2 = c;

            }else{
                goal = c;
            }
        }
        if(c.getType().equals("Keeper")) {
            p.addToTable(p.remove(c));
            goalChecker();
        }
        if(c.getType().equals("Creeper")) {
            p.getOnTable().add(c);
            p.addRemainingPlays(1);
            goalChecker();
        }
        p.addRemainingPlays(-1);
        if(p.getRemainingPlays() == 0)
            changeTurns();
    }

    public static void main(String[]args){
        Table table = new Table();
    }
}
