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



    public String get(int i){
        return hand.get(i).getName();
    }

    public int size(){
        return hand.size();
    }

    public int hasCard(Card name){
	    for(int i = 0; i < hand.size(); i ++){
	        if(hand.get(i).getName().equals(name))
		    return i;
	    }
	    return -1;
    } //search through AL for card; returns index of card or -1 if not there

    public ArrayList<Card> getHand(){
        return hand;
    }

    public int getRemainingPlays(){
        return remainingPlays;
    }

    public void addRemainingPlays(int i){
        remainingPlays += i;
    }

    public ArrayList<Card> getOnTable(){
        return onTable;
    }

    public void draw(Deck d){
        addToHand(d.remove());
    } //draw a card

    public void draw(Deck d, int times){
        for(int i = 0; i < times; i ++){
            draw(d);
        }
    } //draw times cards

    public void discard(Discard dis, int i){
        dis.add(hand.remove(i));
    } //discard an index of hand

    public void discard(Discard dis, Card c){
        int index = -1;
        for( int i = 0; i < hand.size(); i ++){
            if(hand.get(i).equals(c)){
                index = i;
                break;
            }
        }
        discard(dis, index);
    } //discard a card

    public Card remove(int i){
        return hand.remove(i);
    } //remove a card from hand

    public Card remove(Card c){
        for(int i = 0; i < hand.size(); i ++){
            if(hand.get(i).equals(c))
                return c;

        }
        return null;
    }

    public void discardFromTable(Discard dis, Card c){
        for(int i = 0; i < onTable; i ++){
            if(onTable.get(i).equals(c)){
                dis.add(onTable.remove(i));
                break;
            }
        }
    }

    public void addToHand(Card c){
        hand.add(c);
    } //take a card from a source

    public void addToTable(Card c){
        onTable.add(c);
    }

    public void givePlayerCard(Player p2, Card c){
        boolean hasCard = false;
        for(int i = 0; i < hand.size(); i ++){
            if(hand.get(i).equals(c)) {
                p2.addToHand(c);
                hand.remove(i);
                hasCard = true;
            }
        }

        if(hasCard == false){
             System.out.println("Player doesn't have this card");
        }
    } //give another player a card

    public void givePlayerTable(Player p2, Card c){
        boolean hasCard = false;
        for(int i = 0; i < hand.size(); i ++){
            if(hand.get(i).equals(c)){
                p2.addToTable(c);
                onTable.remove(i);
                hasCard = true;
            }
        }

        if(hasCard == false){
            System.out.println("Player doesn't have this card");
        }
    } //give another player something on the table
    
    public String toString(){
        String ret = "" + hand.get(0).getName();
        for(int i = 1; i < hand.size(); i ++){
            ret += ", " + hand.get(i).getName();
        }
        return ret+ "\n";
    }
    
}
