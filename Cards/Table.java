import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Table { //extends JFrame{
    
    private Deck deck; //deck to draw from
    private Discard discard; //discarded cards (action,goals)
    private Goal goal;
    private ArrayList<NewRule> newRule;
    private ArrayList<Player> players;
    /*
    //Gui stuff
    JPanel pane = new JPanel();
    JButton instructions = new JButton("Instructions");
    JButton play = new JButton("Play Game!");
    */
    public Table(){
    /*    //Gui stuff
        super("Fluxx, the Game");
        setBounds(0,0,720,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.add(pane);
        pane.add(play);
        pane.add(instructions);
        setVisible(true);
    */   
        deck = new Deck();
        discard = new Discard();
        newRule = new ArrayList<NewRule>();
        newRule.add(new NewRule("Basic Rules", "Draw 1, Play 1"));
        players = new ArrayList<Player>();
    }
    
    public Deck getDeck(){
        return deck;
    }

    public Discard getDiscard(){
        return discard;
    }
    
    public void setGoal(Goal g){
        goal = g;
    }
    
    public  String getGoal(){
        return goal.getName();
    }
    
    public void addRule(NewRule r){
        newRule.add(r);
    }
    
    public String getRule(){
        String str = "";
        for(NewRule r: newRule){
            str += r.getName();
        }
        return str;
    }
    
    public void addPlayer(Player p){
        players.add(p);
    }
    
    public ArrayList<Card> getPlayerPlayed(int i){
        return players.get(i).getPlayed();
    }
    
    public String toString(){
        String retStr = "";
        for (int x = 0; x < players.size(); x++){
            retStr += "player " + x + " has played " + getPlayerPlayed(x) + "\n";
        }
        retStr += "The goal is : " + goal + "\n";
        retStr += "The rules are : ";
        for (int x = 0; x < newRule.size(); x++){
            retStr += newRule.get(x).getName();
        }
        return retStr;
    }

    public static void main(String[]args){
        Table table = new Table();
        System.out.println(table);
    }
}
