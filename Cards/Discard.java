import java.util.ArrayList;

public class Discard{
    
    private ArrayList<Card> dis;

    public Discard(){
	dis = new ArrayList<Card>();
    }

    public void add(Card card){
	dis.add(card);
    }

    public Card get(int i){
	return dis.get(i);
    }
    
    public int size(){
	return dis.size();
    }
}