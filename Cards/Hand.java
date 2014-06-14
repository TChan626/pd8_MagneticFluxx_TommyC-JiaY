import java.util.ArrayList;

public class Hand{
    
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }

    public String get(int i){
        return hand.get(i).getName();
    }

    public int size(){
        return hand.size();
    }

    public Card remove(int i){
        return hand.remove(i);
    }

    public void add(Card c){
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