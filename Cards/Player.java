import java.util.ArrayList;
import cs1.Keyboard;

public class Player{

    private Hand hand;
    private ArrayList<Card> playing;
    int draw, discard, play;
    
    public Player(){
        hand = new Hand();
        playing = new ArrayList<Card>();
        draw = play = discard = 1;
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
    
    public void draw(Deck deck, Discard dis){
        if(deck.size() == 0){
            deck.reshuffle(dis);
        }
        for (int x = 1; x <= draw; x++){
            hand.add(deck.remove());
        }
    }
    
    public void discard(Discard dis){
        System.out.println("Here is your hand : " + hand.toString());
        for (int x = 1; x <= discard; x++){
            System.out.println("please select a card to discard:");
            String d = Keyboard.readWord();    
            dis.add(hand.remove(d));
        }
    }
    
    public void play(){
        System.out.println("Here is your hand : " + hand.toString());
        for (int x = 1; x <= play; x++){
            System.out.println("please select a card to play:");
            String p = Keyboard.readWord();
            playing.add(hand.remove(p));
        }
    }
    
    public ArrayList<Card> getPlayed(){
        return playing;
    }
    
    public String toString(){
        String ret = "" + playing.get(0).getName();
        for(int i = 1; i < playing.size(); i ++){
            ret += ", " + playing.get(i).getName();
        }
        return ret+ "\n";
    }
    
    public static void main(String[]args){
    
        Deck dec = new Deck();
        Discard dis = new Discard();
        Player me = new Player();
        me.draw(dec,dis);
        me.draw(dec,dis);
        me.draw(dec,dis);
        me.play();
        me.discard(dis);
        
        System.out.println("\nplaying\n" + me.toString());
        System.out.println("hand\n" + me.hand.toString());
        System.out.println("dis\n" + dis.toString());
        //System.out.println("dec\n" + dec.toString());
    }    
}