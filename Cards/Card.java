public class Card{

    private String name,effect,type;

    public Card(String name, String effect, String type){
	this.name = name;
	this.effect = effect;
	this.type = type;
    }

    public String getName(){
	return name;
    }

    public String getEffect(){
	return effect;
    }

    public String getType(){
	return type;
    }

}