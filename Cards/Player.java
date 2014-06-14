import java.util.ArrayList;
import cs1.Keyboard;

public class Player{

    private Hand hand;
    private ArrayList<Card> playing;
    int draw, discard, play;
    
    public Player(){
        hand = new Hand();
        playing = new ArrayList<Card>();
    }
    
    public void setDraw(int i) {
        draw = i;
    }
    
    public void setDiscard(int i) {
        discard = i;
    }
    
    public void setPlay(int i) {
        play = i;
    }
    
    public void draw(Deck deck){
        for (int x = 0; x < draw; x++){
            hand.add(deck.remove());
        }
    }
    
    public void discard(Discard dis){
        for (int x = 0; x < discard; x++){
            System.out.println("please select a card to discard:");
            String d = Keyboard.readWord();    
            dis.add(hand.remove(d));
        }
    }
    
    public void play(){
        for (int x = 0; x < play; x++){
            System.out.println("please select a card to play:");
            String p = Keyboard.readWord();
            playing.add(hand.remove(p));
        }
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
    /*
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
    */
}