import java.util.ArrayList;

public class Player{
    
    private ArrayList<Card> hand;
    private ArrayList<Card> onTable;
    private int remainingPlays;
    

    public Player(){
        hand = new ArrayList<Card>();
	    onTable = new ArrayList<Card>();
        remainingPlays = 1;
    }

    public Player(int i){
        hand = new ArrayList<Card>();
        onTable = new ArrayList<Card>();
        remainingPlays = i;
    }

    public String get(int i){
        return hand.get(i).getName();
    }

    public int size(){
        return hand.size();
    }

    public int hasCard(String name){
	    for(int i = 0; i < hand.size(); i ++){
	        if(hand.get(i).getName().equals(name))
		    return i;
	    }
	    return -1;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public int getRemainingPlays(){
        return remainingPlays;
    }

    public ArrayList<Card> getOnTable(){
        return onTable;
    }

    public void draw(Deck d){
        addToHand(d.remove());
    }

    public void discard(Discard dis, int i){
        dis.add(hand.remove(i));
    }

    public Card remove(int i){
        return hand.remove(i);
    }

    public void addToHand(Card c){
        hand.add(c);
    }
    
    public String toString(){
        String ret = "" + hand.get(0).getName();
        for(int i = 1; i < hand.size(); i ++){
            ret += ", " + hand.get(i).getName();
        }
        return ret+ "\n";
    }
    
}
