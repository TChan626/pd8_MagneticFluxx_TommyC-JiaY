import java.util.ArrayList;

public class Table{

    private int numPlays, numDraws;
    private Deck deck; //deck to draw from
    private Discard discard; //discarded cards (action,goals)
    private Goal goal;
    private NewRule newRule;
    private Player player1;
    private Player player2;
    
    private boolean playerTurn;
    // private Hand player1, player2;
    
					       
    public Table(){
        numPlays = 1;
        numDraws = 1;
        deck = new Deck();
        discard = new Discard();
	
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
    
    public NewRule getNewRule(){
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