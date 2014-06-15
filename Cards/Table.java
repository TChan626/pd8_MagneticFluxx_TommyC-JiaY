import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Table { //extends JFrame{
    
    private Deck deck; //deck to draw from
    private Discard discard; //discarded cards (action,goals)
    private Card goal;
    private Card goal2; //for Double Agenda
    private ArrayList<Card> rules;
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

    public void setGoal(Card g, boolean first){
        boolean isDoubleAgenda = false;
        for(int i = 0; i < rules.size(); i ++){ //check for double agenda
            if(rules.get(i).getName().equals("Double Agenda")){
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
    
    public  String getGoal(){
        return goal.getName();
    }
    
    public void addRule(Card r){
        rules.add(r);
    }
    
    public String getRule(){
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
        //for (int x = 0; x < players.size(); x++){
        //    retStr += "player " + x + " has played " + getPlayerPlayed(x) + "\n";
        //}
        //retStr += "The goal is : " + goal + "\n";
        //retStr += "The rules are : ";
        //for (int x = 0; x < newRule.size(); x++){
        //    retStr += newRule.get(x).getName();
        //}
        return retStr;
    }

    public static void main(String[]args){
        Table table = new Table();
        System.out.println(table);
    }
}
