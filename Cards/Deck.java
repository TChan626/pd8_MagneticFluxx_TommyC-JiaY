import java.util.Collections;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> deck;
    
    public Deck(){
	deck = new ArrayList<Card>(100); //this is a queue
	//insert all of the different cards
	deck.add(new Card("Chocolate", "Chocolate", "Keeper"));
	deck.add(new Card("Brain", "Brain", "Keeper"));
	deck.add(new Card("Bread", "Bread", "Keeper"));
	deck.add(new Card("Chocolate", "Chocolate", "Keeper"));
	deck.add(new Card("Cookies", "Cookies", "Keeper"));
	deck.add(new Card("Cosmos", "Cosmos", "Keeper"));
	deck.add(new Card("Dreams", "Dreams", "Keeper"));
	deck.add(new Card("Love", "Love", "Keeper"));
	deck.add(new Card("Milk", "Milk", "Keeper"));
	deck.add(new Card("Money", "Money", "Keeper"));
	deck.add(new Card("Moon", "Moon", "Keeper"));
	deck.add(new Card("Peace", "Peace", "Keeper"));
	deck.add(new Card("Rocket", "Rocket", "Keeper"));
	deck.add(new Card("Sleep", "Sleep", "Keeper"));
	deck.add(new Card("Sun", "Sun", "Keeper"));
	deck.add(new Card("Television", "Television", "Keeper"));
	deck.add(new Card("Time", "Time", "Keeper"));
	deck.add(new Card("Toaster", "Toaster", "Keeper"));
	deck.add(new Card("Eye", "Eye", "Keeper"));
	deck.add(new Card("Party", "Party", "Keeper"));
	deck.add(new Card("War", "If you have Peace, move this card to another player", "Creeper"));
	deck.add(new Card("Death", "At the start of your turn, discard one of your other Keepers or Creepers. If you have no other Keepers or Creepers, you may discard Death", "Creeper"));
	deck.add(new Card("Taxes", "If you have Money, discard both Taxes and Money", "Creeper"));
	deck.add(new Card("Radioactive Potato", "If the Goal is changed, move this card to the player on your right", "Creeper"));
	deck.add(new Card("Jackpot", "Draw 3 Cards", "Action"));
	deck.add(new Card("Discard and Draw", "Discard your hand and draw new cards equal to the number of cards in your hand", "Action"));
	deck.add(new Card("Draw 2 and use 'em", "Set your hand aside. Draw 2 cards and play them immediately.", "Action"));
	deck.add(new Card("Draw 3, Play 2 of them", "Set your hand aside. Draw 3 cards, play 2 of them. Discard the remaining one.", "Action"));
	deck.add(new Card("Everybody Gets 1", "Draw cards equal to the number of players. Give one of these cards to every player. You decide who gets what.", "Action"));
	deck.add(new Card("Exchange Keepers", "Exchange Keepers with another player. If there are no Keepers, do not do anything.", "Action"));
	deck.add(new Card("Let's Do That Again", "Look through the discard pile. You may choose and play one New Rule or Action card.", "Action"));
	deck.add(new Card("Let's Simplify", "You may discard New Rules up to the number of New Rules divided by two (rounded up).", "Action"));
	deck.add(new Card("No Limits", "Discard any Keeper or Hand Limits in play.", "Action"));
	deck.add(new Card("Rotate Hands", "All players rotate hands in the direction you choose.", "Action"));
	deck.add(new Card("Rules Reset", "Discard all New Rules in play.", "Action"));
	deck.add(new Card("Take Another Turn", "Take another turn immediately after this turn ends.", "Action"));
	deck.add(new Card("Taxation", "Take 1 card from every player.", "Action"));
	deck.add(new Card("Trade Hands", "Trade hands with another player.", "Action"));
	deck.add(new Card("Trash a New Rule", "Trash a New Rule in play.", "Action"));
	deck.add(new Card("Use What You Take", "Take a card from antoher player and play it.", "Action"));
	deck.add(new Card("Creeper Sweeper", "All Creepers in play are discarded.", "Action"));
	deck.add(new Card("Trash Something", "Trash a Keeper or Creeper", "Action"));
	deck.add(new Card("Steal Something", "Steal a Keeper or Creeper from another player", "Action"));
	deck.add(new Card("Mix It All Up", "Take all Keepers and Creepers in play. Distribute them amongst all other players in turn order with you starting.", "Action"));
	deck.add(new Card("Today's Special", "Set your hand aside. Draw 3 cards. If today is your birthday, play all 3. If today is a holiday, play 2. Otherwise, play only 1.", "Action"));
	deck.add(new Card("It's Trash Day", "All players may discard any card from their hand or in play. Shuffle the discard pile back into the Deck.", "Action"));
	//Collections.shuffle(deck);
    }
    
    public void reshuffle(Discard dis){
	for(int i = 0; i < dis.size(); i ++){
	    deck.add(dis.get(i));
	}
	Collections.shuffle(deck);
    }

    public int size(){
	return deck.size();
    }

    public Card draw(){
	return deck.remove(0);
    }

    public String toString(){
	String ret = "";
	for(int i = 0; i < deck.size(); i ++){
	    ret += deck.get(i).getName() + ",";
	}
	return ret;
    }

    public static void main(String[]args){
	Deck deck = new Deck();
	System.out.println(deck);
    }
}