import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
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

    private boolean inflation;


    String eol = System.getProperty("line.separator"); //in order to differentiate for different OSes
    //Gui stuff
    JPanel pane;
    
    JTextArea instructions = new JTextArea(
            "How to Play:" + eol + eol + 
                    "Fluxx is a game with one basic rule: Draw 1, Play 1." + eol + eol + 
                    "As the game goes on, new Rules can be put into place. These rules will change" + eol + eol + 
                    "how the game plays. There is no Goal of the game until someone plays one." + eol + 
                    "On your turn, draw the number of cards required, play the number of cards required," + eol + eol + 
                    "Discard down to the current Hand Limit (if any) and Keeper Limit (if any)." + eol + eol + 
                    "The game will continue until one player meets the conditions of the current Goal."
    );
    
    JButton play = new JButton("Play Game!");   
    
    
    public Table(){
        //Gui stuff
        super("Fluxx, the Game");
        setBounds(0,0,720,720);
        JPanel pane = new JPanel();
        //try {
            
            //File title = new File("./Card Images/_CARD BACK.jpg");
            //BufferedImage introPic = ImageIO.read(title);
            
            
            Container container = this.getContentPane();
            container.setBackground(Color.WHITE);
            ImageIcon image = new ImageIcon("Card Images/_CARD BACK.jpg");
            JLabel j = new JLabel(" ", image, JLabel.CENTER);
            
            pane.add(j);
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            container.add(pane);
            
            JPanel southPanel = new JPanel();
            southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
            southPanel.add(instructions, BorderLayout.CENTER);
            instructions.setEditable(false); 
            instructions.setFont(new Font("Serif", Font.ITALIC, 16));
            instructions.setWrapStyleWord(true);
            southPanel.add(play, BorderLayout.CENTER);
            pane.add(BorderLayout.SOUTH, southPanel );
            
            setVisible(true);
        //}catch(IOException e){
        //    System.out.println("Error 404: File not found");
        //}

        rules = new ArrayList<Card>();
        goal = null;
        goal2 = null;
        inflation = false;

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


    public void play(Card c){
        if(c.getType().equals("Action")) {

        }
        if(c.getType().equals("NewRule")){

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
            p.discard(discard,c);
        }else{
            p.draw(deck, 3);
            p.addRemainingPlays(2);
            p.discard(discard,c);
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
        play(c);
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

    public void noLimits(Player p) {
        p.discard(discard, deck.NOLIMITS);
        for (int i = 0; i < rules.size(); i++) {
            if (rules.get(i).equals(deck.HL0) || rules.get(i).equals(deck.HL1) || rules.get(i).equals(deck.HL2) ||
                    rules.get(i).equals(deck.KL2) || rules.get(i).equals(deck.KL3) || rules.get(i).equals(deck.KL4)) {
                rules.remove(i);
                i--;
            }
        }
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

    public String toString(){
        String retStr = "";
        return retStr;
    }

    public static void main(String[]args){
        Table table = new Table();
    }
}
