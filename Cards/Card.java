public class Card{

    private String name,effect;

    public Card(String name, String effect){
	this.name = name;
	this.effect = effect;
    }

    public String getName(){
	return name;
    }

    public String getEffect(){
	return effect;
    }

    public void discard(){
    }

}