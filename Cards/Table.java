import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 public class Table extends JFrame{
    private int numPlays, numDraws;
    private Deck deck; //deck to draw from
    private Discard discard; //discarded cards (action,goals)
    private Goal goal;
    private NewRule newRule;
    private Player player1;
    private Player player2;
    private ArrayList<NewRule> newRules;
    JPanel pane = new JPanel();
    JButton instructions = new JButton("Instructions");
    JButton play = new JButton("Play Game!");
    
    private boolean playerTurn;
    // private Hand player1, player2;
    
					       
    public Table(){
        //Gui stuff
        super("Fluxx, the Game");
        setBounds(0,0,720,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.add(pane);
        pane.add(play);
        pane.add(instructions);
        setVisible(true);
        numPlays = 1;
        numDraws = 1;
        deck = new Deck();
        discard = new Discard();
        newRules = new ArrayList<NewRule>();
	
	//playerTurn = Math.random() > 0.5;
        player1 = new Player();
        player2 = new Player();
	
	//for(int i = 0; i < 3; i ++){
	//    player1.draw(deck);
	//    player2.draw(deck);
	//}
    }
    /*
    public void setNumPlays(int i){
	numPlays = i;
    }

    public void setNumDraws(int i){
	numDraws = i;
    }
    */
    
    public Deck getDeck(){
        return deck;
    }

    public Discard getDiscard(){
        return discard;
    }
    
    public  Goal getGoal(){
        return goal;
    }
    
    public ArrayList<NewRule> getNewRule(){
        return newRule;
    }

    public ArrayList<Card> getPlayed1(){
        return player1.getPlayed();
    }
    
    public ArrayList<Card> getPlayed2(){
        return player2.getPlayed();
    }
    /*
    public Hand getPlayer(boolean player){
	if(player == true)
	    return player1;
	else
	    return player2;
    }
    */

    public static void main(String[]args){
        Table table = new Table();
        Deck dec = new Deck();
        System.out.println(dec.toString());
    }
}