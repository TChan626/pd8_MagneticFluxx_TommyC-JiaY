import java.util.ArrayList;

public class Player{

    private Hand hand;
    private ArrayList<Card> playing;
    
    public Player(){
        hand = new Hand();
        playing = new ArrayList<Card>();
    }
    
    public void draw(Deck deck){
        hand.add(deck.remove());
    }
    
    public void discard(Discard discard, String card){
        discard.add(hand.remove(card));
    }
    
    public void play(String card){
        playing.add(hand.remove(card));
    }
    
    public ArrayList<Card> getPlayed(){
        return playing;
    }
    
    public String playToString(){
        String ret = "";
        for (Card c: playing){
            ret += c.getName() +"\n";
        }
        return ret;
    }

    
    public static void main(String[]args){
        Deck dec = new Deck();
        Discard dis = new Discard();
        Player me = new Player();
        me.draw(dec);
        me.draw(dec);
        me.draw(dec);
        me.play("Bread");
        me.discard(dis, "Brain");
        
        System.out.println("playing\n" + me.playToString());
        System.out.println("hand\n" + me.hand.toString());
        System.out.println("dis\n" + dis.toString());
        System.out.println("dec\n" + dec.toString());
    }    
}