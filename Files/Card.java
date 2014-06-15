import java.awt.*;
import java.io.File;

public class Card{

    private String name,type;
    private File file;
    private Image picture;

    public Card(String name, String type, String file){
	    this.name = name;
	    this.type = "";
        this.file = new File(file);
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
