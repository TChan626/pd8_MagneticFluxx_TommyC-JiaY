import java.util.ArrayList;

public class Hand{
    
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }

    public Card get(int i){
        return hand.get(i);
    }

    public int size(){
        return hand.size();
    }

    public Card remove(Card c){
        for(int i = 0; i < hand.size(); i++)
            if (hand.get(i).equals(c)){
                return hand.remove(i);
            }
        return null;
    }

    public void add(Card c){
        hand.add(c);
    }
}