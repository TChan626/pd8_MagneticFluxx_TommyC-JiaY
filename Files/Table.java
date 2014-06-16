import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
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
    //Gui stuff
    JPanel pane = new JPanel();
    JTextArea instructions = new JTextArea(
            "How to Play:" + eol + eol + eol +
                    "Fluxx is a game with one basic rule: Draw 1, Play 1." + eol + eol +
                    "As the game goes on, new Rules can be put into place. These rules will change" + eol +
                    "how the game plays. There is no Goal of the game until someone plays one." + eol + eol + eol + eol +
                    "On your turn, draw the number of cards required, play the number of cards required," + eol +
                    "Discard down to the current Hand Limit (if any) and Keeper Limit (if any)." + eol + eol +
                    "The game will continue until one player meets the conditions of the current Goal."
    );
    JButton playButton = new JButton("Play Game!");

    public Table(){
        //Gui stuff
        super("Fluxx, the Game");
        setBounds(0,0,720,720);
        //try {
            //File title = new File("./Card Images/_CARD BACK.jpg");
            //BufferedImage introPic = ImageIO.read(title);
            //JLabel label = new JLabel(new ImageIcon(introPic));
            Container container = this.getContentPane();
            container.setBackground(Color.WHITE);
            container.add(new JLabel(new ImageIcon("./Card Images/_CARD BACK.jpg")));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            container.add(pane);
            pane.add(instructions);
            pane.add(playButton);
            setVisible(true);
        //}catch(IOException e){
        //    System.out.println("Error 404: File not found");
        //}

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

    public  String getGoal(){
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


    public void play(Card c) {
        if (c.getType().equals("Action")) {

        }
        if (c.getType().equals("NewRule")) {

        }
        if (c.getType().equals("Goal")){

        }
        if(c.getType().equals("Keeper") || c.getType().equals("Creeper")) {

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

    public void everybodyGetsOne(Player p, Player p2, boolean first){
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

    public void exchangeKeepers(Player p1, Player p2, Card c1, Card c2){
        p1.discard(discard, deck.EXCHANGE);
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
        p1.play(c);
    }

    public void letsSimplify(Player p){
        p.discard(discard, deck.SIMPLIFY);
        int half = 0;
        if(rules.size() % 2 == 0)
            half = rules.size() / 2;
        else
            half = rules.size() / 2 + 1;

        for(int i = 0; i < half; i ++){

        }
    }

    //public void noLimits(Player p) {
    //    p.discard(discard, deck.NOLIMITS);
    //    for (int i = 0; i < rules.size(); i++) {
    //        if (rules.get(i).equals(deck.HL0) || rules.get(i).equals(deck.HL1) || rules.get(i).equals(deck.HL2) ||
    //                rules.get(i).equals(deck.KL2) || rules.get(i).equals(deck.KL3) || rules.get(i).equals(deck.KL4)) {
    //            rules.remove(i);
    //            i--;
    //        }
    //    }
    //}

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

    public void takeAnotherTurn(Player p){
        p.discard(discard, deck.TURN2);
        boolean turn2 = false;
        while(p.getRemainingPlays() == 0 && turn2 == true){
            p.draw(deck,draw);
            p.addRemainingPlays(play);
            turn2 = true;
        }
    }

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

    public void useWhatYouTake(Player p1, Player p2){
        p1.discard(discard, deck.USETAKE);

        p1.play(p2.getHand().get(0));
    }

    public void creeperSweeper(Player p1){
        p1.discard(discard, deck.SWEEPER);

        for(int i = 0; i < players.size(); i ++){
            if(players.get(i).hasCard(deck.WAR) || players.get(i).hasCard(deck.DEATH) ||
               players.get(i).hasCard(deck.TAXES) || players.get(i).hasCard(deck.POTATO)){
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
        for (int i = 0; i < p1.onTable().size(); i++) {
            stuff.add(p1.onTable().get(i));
        }

        for (int i = 0; i < p2.onTable().size(); i++) {
            stuff.add(p2.onTable().get(i));
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
        Card[]options = p2.onTable().size();

        for(int i = 0; i < p2.onTable().size(); i ++) {
            options[i] = p2.onTable().get(i);
        }

        Card c = (Card)JOptionPane.showInputDialog(this, "Choose a card to steal:", "Steal Something",
                                                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        p1.onTable().add(p2.onTable().remove(c));
    }

    public void mixItAllUp(Player p){
        p.discard(discard, deck.MIX);
        ArrayList<Card> mixer = new ArrayList<Card>();
        for(int i = 0; i < players.size(); i ++){
            for(int a = 0; a < players.get(i).getOnTable(); a ++){
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
        rules.add(p.remove(deck.DRAW2));
        prevDraw = draw;
        if(inflation) {
            draw = 3;
        }else {
            draw = 2;
        }
        if(prevDraw < draw){
            p.draw(draw - prevDraw);
        }
    }
    public void draw3(Player p){
        rules.add(p.remove(deck.DRAW3));
        prevDraw = draw;
        if(inflation) {
            draw = 4;
        }else {
            draw = 3;
        }
        if(prevDraw < draw){
            p.draw(draw - prevDraw);
        }
    }
    public void draw4(Player p){
        rules.add(p.remove(deck.DRAW4));
        prevDraw = draw;
        if(inflation) {
            draw = 5;
        }else {
            draw = 4;
        }
        if(prevDraw < draw){
            p.draw(draw - prevDraw);
        }
    }
    public void draw5(Player p){
        rules.add(p.remove(deck.DRAW5));
        prevDraw = draw;
        if(inflation) {
            draw = 6;
        }else {
            draw = 5;
        }
        if(prevDraw < draw){
            p.draw(draw - prevDraw);
        }
    }

    public void play2(Player p){
        rules.add(p.remove(deck.PLAY2));
        if(inflation)
            play = 3;
        else
            play = 2;
    }
    public void play3(Player p){
        rules.add(p.remove(deck.PLAY3));
        if(inflation)
            play = 4;
        else
            play = 3;
    }
    public void play4(Player p){
        rules.add(p.remove(deck.PLAY4));
        if(inflation)
            play = 5;
        else
            play = 4;
    }
    public void playAll(Player p){
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



    public void tenCards(Player p){
        
    }


    public String toString(){
        String retStr = "";
        return retStr;
    }

    public static void main(String[]args){
        Table table = new Table();
    }
}
