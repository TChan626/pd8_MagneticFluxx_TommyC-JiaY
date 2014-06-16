import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Image;
import java.io.File;

public class Card{

    private String name,type;
    private ImageIcon picture;

    public Card(String name, String type, String file){
	    this.name = name;
	    this.type = "";
        this.picture = new ImageIcon(file);
    }

    public String getName(){
	    return name;
    }

    public String getType(){
	    return type;
    }

    public ImageIcon getPicture(){
        return picture;
    }

}
