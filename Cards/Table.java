

public class Table{

    private int numPlays, numDraws;
    private Deck deck;
    private Discard discard;
    
    private boolean playerTurn;
    private Hand player1, player2;
    
					       
    public Table(){
	numPlays = 1;
	numDraws = 1;
	deck = new Deck();
	discard = new Discard();
	
	playerTurn = Math.random() > 0.5;
	player1 = new Hand();
	player2 = new Hand();
	
	for(int i = 0; i < 3; i ++){
	    player1.draw(deck);
	    player2.draw(deck);
	}
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

    public Hand getPlayer(boolean player){
	if(player == true)
	    return player1;
	else
	    return player2;
    }



    public static void main(String[]args){

	Table table = new Table();
	Deck dec = new Deck();
	System.out.println(dec.toString());
    }
}