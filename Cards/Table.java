import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Table extends JFrame{


    private int numPlays, numDraws;
    private Deck deck; //deck to draw from
    private Discard discard; //discarded cards (action,goals)
    private Goal goal;
    private ArrayList<NewRule> newRules;
    private Hand player1;
    private Hand player2;
    
    private ArrayList<Card> p1Stuff;
    private ArrayList<Card> p2Stuff;
    
    private boolean playerTurn;
    // private Hand player1, player2;
    
			
    JPanel pane = new JPanel();
    JButton instructions = new JButton("Instructions");
    JButton play = new JButton("Play Game!");

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

	p1Stuff = p2Stuff = new ArrayList<Card>();
	
	// playerTurn = Math.random() > 0.5;
        // player1 = new Hand();
        // player2 = new Hand();
	
	// for(int i = 0; i < 3; i ++){
	//    player1.draw(deck);
	//    player2.draw(deck);
	// }
    }

    public void setNumPlays(int i){
	numPlays = i;
    }

    public void setNumDraws(int i){
	numDraws = i;
    }
    
    public Deck getDeck(){
        return deck;
    }

    public Discard getDiscard(){
        return discard;
    }
    
    public  Goal getGoal(){
        return goal;
    }
    
    public ArrayList<NewRule> getNewRules(){
        return newRules;
    }

    // public ArrayList<Card> getPlayed1(){
    //     return player1.getPlayed();
    // }
    
    // public ArrayList<Card> getPlayed2(){
    //     return player2.getPlayed();
    // }

    // public Hand getPlayer(boolean player){
    // 	if(player == true)
    // 	    return player1;
    // 	else
    // 	    return player2;
    // }

    public static void main(String[]args){
        // Table table = new Table();
        // Deck dec = new Deck();
        // System.out.println(dec.toString());
	Table table = new Table();
    }
}