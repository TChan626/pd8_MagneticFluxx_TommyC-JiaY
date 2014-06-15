import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
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
    JButton play = new JButton("Play Game!");

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
            pane.add(play);
            setVisible(true);
        //}catch(IOException e){
        //    System.out.println("Error 404: File not found");
        //}

        rules = new ArrayList<Card>();
        goal = null;
        goal2 = null;


        deck = new Deck();
        discard = new Discard();
        players = new ArrayList<Player>();
    }
    
    public Deck getDeck(){
        return deck;
    }

    public Discard getDiscard(){
        return discard;
    }
    
    public void setGoal(Card g){
        goal = g;
    }

    public void setGoal(Card g, boolean first){ //Double Agenda
        boolean isDoubleAgenda = false;
        for(int i = 0; i < rules.size(); i ++){ //check for double agenda
            if(rules.get(i).getName().equals(deck.DOUBLEAGENDA)){
                isDoubleAgenda = true;
            }
        }

        if(isDoubleAgenda) {
            if (first)
                goal = g;
            else
                goal2 = g;
        }
    }

    public void warEffect(Player p1, Player p2){
        boolean hasPeace = (p1.hasCard(deck.PEACE) != -1);
        boolean hasWar = (p1.hasCard(deck.WAR) != -1);

        if(hasPeace == true && hasWar == true){
            p1.givePlayer(p2, deck.WAR);
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
        p1.givePlayer(p2, deck.POTATO);
    }

    public void deathEffect(Player p, Card c){
        if(p.getOnTable().size() == 1) {
            int n = JOptionPane.showConfirmDialog(this, "Would you like to discard Death?", "Death Beckons", JOptionPane.YES_NO_OPTION);
        }else{
            Card[]possibilities = new Card[p.size() - 1];
            for(int i = 0; i < p.size(); i ++){
                if(p.hasCard(deck.DEATH) != -1)
                    possibilities[i] = p.getHand().get(i);
                
            }
            ArrayList<Card> possibilities = new ArrayList<Card>(p.size() - 1);
            for(int i = 0; i < p.size(); i ++){
                if(p.hasCard(deck.DEATH) != i){
                    possibilities.add(p.getHand().get(i));
                }
            }

            String s = (String)JOptionPane.showInputDialog(this, "Which card would you like to discard?", "Death Beckons", JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities.get(0));
        }
    }
    
    public  String getGoal(){
        return goal.getName();
    }
    
    public void addRule(Card r){
        rules.add(r);
    }
    
    public String getRules(){
        String str = "";
        for(Card r: rules){
            str += r.getName() + ", ";
        }
        return str;
    }
    
    public void addPlayer(Player p){
        players.add(p);
    }
    
    public String toString(){
        String retStr = "";
        return retStr;
    }

    public static void main(String[]args){
        Table table = new Table();
    }
}
