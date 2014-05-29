public class NewRule extends Card{

    private String name,effect,type;
   
    public NewRule(String name, String effect, String type){
	this.name = name;
	this.effect = effect;
	this.type = type;
    }

    public ArrayList<Card> draw(int i, Deck deck){
	ArrayList<Card> stuff = new ArrayList<Card>(i);
	for(int d = 0; d < i; d ++){
	    stuff.add(deck.draw());
	}
	return stuff;
    }

}