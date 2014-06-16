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

    public Card getLast(){
        return dis.get(dis.size() - 1);
    }
    
    public int size(){
	return dis.size();
    }
    
    public String toString(){
        String ret = dis.get(0).getName();
        for(int i = 1; i < dis.size() - 1; i ++){
            ret += ", " + dis.get(i).getName();
        }
        ret += dis.get(dis.size() - 1).getName();
        return ret;
    }
}