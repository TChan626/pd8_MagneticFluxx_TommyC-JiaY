import java.util.Collections;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> deck;
    
    public Deck(){
	deck = new ArrayList<Card>(100); //this is a queue
	//insert all of the different cards
	deck.add(new Keeper("Chocolate","Chocolate"));
	deck.add(new NewRule("Play All","Play all of your cards","Play"));
	Collections.shuffle(deck);
    }
    
    public void reshuffle(Discard dis){
	for(int i = 0; i < dis.size(); i ++){
	    deck.add(dis.get(i));
	}
	Collections.shuffle(deck);
    }

    public int size(){
	return deck.size();
    }

    public Card draw(){
	return deck.remove(0);
    }

    public String toString(){
	String ret = "";
	for(int i = 0; i < deck.size(); i ++){
	    ret += deck.get(i) + ",";
	}
	return ret;
    }
}