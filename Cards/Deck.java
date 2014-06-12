import java.util.Collections;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> deck;
    
    public Deck(){
	deck = new ArrayList<Card>(100); //this is a queue
	//insert all of the different cards
	deck.add(new Keeper("Brain", "Brain"));
	deck.add(new Keeper("Bread", "Bread"));
	deck.add(new Keeper("Chocolate", "Chocolate"));
	deck.add(new Keeper("Cookies", "Cookies"));
	deck.add(new Keeper("Cosmos", "Cosmos"));
	deck.add(new Keeper("Dreams", "Dreams"));
	deck.add(new Keeper("Love", "Love"));
	deck.add(new Keeper("Milk", "Milk"));
	deck.add(new Keeper("Money", "Money"));
	deck.add(new Keeper("Moon", "Moon"));
	deck.add(new Keeper("Peace", "Peace"));
	deck.add(new Keeper("Rocket", "Rocket"));
	deck.add(new Keeper("Sleep", "Sleep"));
	deck.add(new Keeper("Sun", "Sun"));
	deck.add(new Keeper("Television", "Television"));
	deck.add(new Keeper("Time", "Time"));
	deck.add(new Keeper("Toaster", "Toaster"));
	deck.add(new Keeper("Eye", "Eye"));
	deck.add(new Keeper("Party", "Party"));
	deck.add(new Creeper("War", "If you have Peace, move this card to another player"));
	deck.add(new Creeper("Death", "At the start of your turn, discard one of your other Keepers or Creepers. If you have no other Keepers or Creepers, you may discard Death"));
	deck.add(new Creeper("Taxes", "If you have Money, discard both Taxes and Money"));
	deck.add(new Creeper("Radioactive Potato", "If the Goal is changed, move this card to the player on your right"));
	deck.add(new Action("Jackpot", "Draw 3 Cards"));
	deck.add(new Action("Discard and Draw", "Discard your hand and draw new cards equal to the number of cards in your hand"));
	deck.add(new Action("Draw 2 and use 'em", "Set your hand aside. Draw 2 cards and play them immediately."));
	deck.add(new Action("Draw 3, Play 2 of them", "Set your hand aside. Draw 3 cards, play 2 of them. Discard the remaining one."));
	deck.add(new Action("Everybody Gets 1", "Draw cards equal to the number of players. Give one of these cards to every player. You decide who gets what."));
	deck.add(new Action("Exchange Keepers", "Exchange Keepers with another player. If there are no Keepers, do not do anything."));
	deck.add(new Action("Let's Do That Again", "Look through the discard pile. You may choose and play one New Rule or Action card."));
	deck.add(new Action("Let's Simplify", "You may discard New Rules up to the number of New Rules divided by two (rounded up)."));
	deck.add(new Action("No Limits", "Discard any Keeper or Hand Limits in play."));
	deck.add(new Action("Rotate Hands", "All players rotate hands in the direction you choose."));
	deck.add(new Action("Rules Reset", "Discard all New Rules in play."));
	deck.add(new Action("Take Another Turn", "Take another turn immediately after this turn ends."));
	deck.add(new Action("Taxation", "Take 1 card from every player."));
	deck.add(new Action("Trade Hands", "Trade hands with another player."));
	deck.add(new Action("Trash a New Rule", "Trash a New Rule in play."));
	deck.add(new Action("Use What You Take", "Take a card from antoher player and play it."));
	deck.add(new Action("Creeper Sweeper", "All Creepers in play are discarded."));
	deck.add(new Action("Trash Something", "Trash a Keeper or Creeper"));
	deck.add(new Action("Steal Something", "Steal a Keeper or Creeper from another player"));
	deck.add(new Action("Mix It All Up", "Take all Keepers and Creepers in play. Distribute them amongst all other players in turn order with you starting."));
	deck.add(new Action("Today's Special", "Set your hand aside. Draw 3 cards. If today is your birthday, play all 3. If today is a holiday, play 2. Otherwise, play only 1."));
	deck.add(new Action("It's Trash Day", "All players may discard any card from their hand or in play. Shuffle the discard pile back into the Deck."));
	deck.add(new Goal("10 Cards in Hand", "If at least one player has more than 10 cards in their hand, the player with the most cards in hand wins. In the case of a tie, continue until a clear winner is shown."));
	deck.add(new Goal("5 Keepers", "If at least one player has more than 5 Keepers in their hand, the player with the most Keepers in play wins. In the case of a tie, continue until a clear winner is shown."));
	deck.add(new Goal("All You Need is Love", "The player with Love wins if they have no other Keepers"));
	deck.add(new Goal("Appliances", "The player with the TV and the Toaster wins"));
	deck.add(new Goal("Baked Goods", "The player with Bread and Cookies wins"));
	deck.add(new Goal("Bed Time", "The player with Sleep and Dreams wins"));
	deck.add(new Goal("Brain (no TV)", "The player with the Brain wins if the TV is not in play"));
	deck.add(new Goal("Chocolate Cookies", "The player with Chocolate and Cookies wins"));
	deck.add(new Goal("Chocolate Milk", "The player with Chocolate and Milk wins"));
	deck.add(new Goal("Death by Chocolate", "The player with Death and Chocolate wins"));
	deck.add(new Goal("Dreamland", "The player with Dreams and Cosmos wins"));
	deck.add(new Goal("Hearts and Minds", "The player with Love and the Brain wins"));
	deck.add(new Goal("Hippyism", "The player with Love and Peace wins"));
	deck.add(new Goal("Milk and Cookies", "The player with Milk and Cookies wins"));
	deck.add(new Goal("Night and Day", "The player with the Moon and the Sun wins"));
	deck.add(new Goal("Peace (no War)", "The player with Peace wins if War is not in play"));
	deck.add(new Goal("Rocket Science", "The player with the Rocket and the Brain wins"));
	deck.add(new Goal("Rocket to the Moon", "The player with the Rocket and the Moon wins"));
	deck.add(new Goal("Squishy Chocolate", "The player with Chocolate and the Sun wins"));
	deck.add(new Goal("Time is Money", "The player with Time and Money wins"));
	deck.add(new Goal("Toast", "The player with Bread and the Toaster wins"));
	deck.add(new Goal("War = Death", "The player with War and Death wins"));
	deck.add(new Goal("Winning the Lottery", "The player with Money and Dreams wins"));
	deck.add(new Goal("Mind's Eye", "The player with the Brain and the Eye wins"));
	deck.add(new Goal("Dough", "The player with Money and Bread wins"));
	deck.add(new Goal("All That Is Certain", "The player with Death and Taxes wins"));
	deck.add(new Goal("Interstellar Spacecraft", "The player with the Rocket and Cosmos wins"));
	deck.add(new Goal("Star Gazing", "The player with the Eye and Cosmos wins"));
	deck.add(new Goal("Party Snacks", "The player with the Party and at least one of Bread, Chocolate, or Cookies wins"));
	deck.add(new NewRule("Draw 2", "Draw 2 cards per turn. The person who played this should draw extra cards right away (if needed) so that they have drawn 2 cards this turn."));
	deck.add(new NewRule("Draw 3", "Draw 3 cards per turn. The person who played this should draw extra cards right away (if needed) so that they have drawn 3 cards this turn."));
	deck.add(new NewRule("Draw 4", "Draw 4 cards per turn. The person who played this should draw extra cards right away (if needed) so that they have drawn 4 cards this turn."));
	deck.add(new NewRule("Draw 5", "Draw 5 cards per turn. The person who played this should draw extra cards right away (if needed) so that they have drawn 5 cards this turn."));
	deck.add(new NewRule("Play 2", "Play 2 cards per turn. If you have fewer than 2 cards in your hand, play all your cards."));
	deck.add(new NewRule("Play 3", "Play 3 cards per turn. If you have fewer than 3 cards in your hand, play all your cards."));
	deck.add(new NewRule("Play 4", "Play 4 cards per turn. If you have fewer than 4 cards in your hand, play all your cards."));
	deck.add(new NewRule("Play All", "Play all of your cards per turn."));
	deck.add(new NewRule("Hand Limit 0", "If it isn't your turn, you can only have 0 cards in your hand - discard your choice of extras immediately. During your turn, this rule does not apply to you; when your turn is over, discard down to 0 cards."));
	deck.add(new NewRule("Hand Limit 1", "If it isn't your turn, you can only have 1 cards in your hand - discard your choice of extras immediately. During your turn, this rule does not apply to you; when your turn is over, discard down to 1 cards."));
	deck.add(new NewRule("Hand Limit 2", "If it isn't your turn, you can only have 2 cards in your hand - discard your choice of extras immediately. During your turn, this rule does not apply to you; when your turn is over, discard down to 2 cards."));
	deck.add(new NewRule("Keeper Limit 2", "Except during your turn, you can only have 2 Keepers in play. Discard extras (of your choice) immedaitely. You may play new Keepers during your turn as long as you discard to 2 when your turn ends."));
	deck.add(new NewRule("Keeper Limit 3", "Except during your turn, you can only have 3 Keepers in play. Discard extras (of your choice) immedaitely. You may play new Keepers during your turn as long as you discard to 3 when your turn ends."));
	deck.add(new NewRule("Keeper Limit 4", "Except during your turn, you can only have 4 Keepers in play. Discard extras (of your choice) immedaitely. You may play new Keepers during your turn as long as you discard to 4 when your turn ends."));
	deck.add(new NewRule("Double Agenda", "Two Goals may be played at once."));
	deck.add(new NewRule("First Play Random", "The player to your left chooses your first play. Disregard this rule if the current rules only allow the player to play one card."));
	deck.add(new NewRule("No-Hand Bonus", "If you have no cards at the start of your turn, draw 3 extra cards in addition to the current Draw rules."));
	deck.add(new NewRule("Poor Bonus", "If one player has fewer Keepers than any other player, that player draws 1 extra card. Disregard this rule if there is a tie."));
	deck.add(new NewRule("Rich Bonus", "If one player has more Keepers than any other player, that player plays 1 extra card. Disregard this rule if there is a tie."));
	deck.add(new NewRule("Inflation", "All numerals in cards are increased by one. For example, 3 becomes 4, but three does not become four. This does apply to the Basic Rules."));
	deck.add(new NewRule("Party Bonus", "If the Party is in play, draw and play 1 additional card per turn."));
	deck.add(new NewRule("Get On With It!", "You may choose to discard your entire hand during your turn. You draw 3 new cards. This is a free action, but your turn ends immediately."));
	deck.add(new NewRule("Silver Lining", "Creepers do not prevent you from winning."));
	deck.add(new NewRule("You Also Need a Potato", "If the Radioactive Potato is in play, players must also have it in addition to the current Goal in order to win."));
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

    public Card remove(){ //draw 1st card
        return deck.remove(0);
    }

    public String toString(){
        String ret = "";
        for(int i = 0; i < deck.size(); i ++){
            ret += deck.get(i).getName() + "\n";
        }
        return ret;
    }
}