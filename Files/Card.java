import java.awt.*;

public class Card{

    private String name,type;
    private Image picture;

    public Card(String name, String type/*, Image picture*/){
	    this.name = name;
	    this.type = "";
    //this.picture = picture;
    }

    public String getName(){
	    return name;
    }

    public String getType(){
	    return type;
    }

    public Image getPicture(){
        return picture;
    }

}
