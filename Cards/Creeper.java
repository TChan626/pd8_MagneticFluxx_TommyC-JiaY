public class Creeper implements Card{

    private String name;
    private String effect;
    
    public Creeper(String name, String effect){
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