public class Action extends Card{

    private String name,effect,type;

    public Action(String name,String effect){
	super(name,effect);
	type = "Action";
    }
}