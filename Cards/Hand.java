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

    public Card remove(String name){
        for(int i = 0; i < hand.size(); i++)
            if (hand.get(i).getName().equals(name)){
                return hand.remove(i);
            }
        return null;
    }

    public void add(Card c){
        hand.add(c);
    }
    
    public String toString(){
        String ret = "";
        for(int i = 0; i < hand.size(); i ++){
            ret += hand.get(i).getName() + "\n";
        }
        return ret;
    }
    
}