import java.util.ArrayList;

public class Hand{
    
    private ArrayList<Card> cards;

    public Hand(){
	cards = new ArrayList<Card>();
    }

    public Card get(int i){
	return cards.get(i);
    }

    public int size(){
	return cards.size();
    }

    public void discard(int i, Discard dis){
	dis.add(cards.remove(i));
    }

    public void draw(Deck d){
	cards.add(d.draw());
    }

    public Card play(int i){
	return cards.remove(i);
    }
}