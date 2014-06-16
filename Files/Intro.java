import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro extends JFrame implements ActionListener{

    public static final String eol = System.getProperty("line.separator");

    private JPanel pane;
    private JButton playGame;
    private JTextArea instructions;


    public Intro(){
        super("Fluxx, the Game");
        setBounds(0,0,720,720);
        instructions = new JTextArea(
                "How to Play:" + eol + eol + eol +
                        "Fluxx is a game with one basic rule: Draw 1, Play 1." + eol + eol +
                        "As the game goes on, new Rules can be put into place. These rules will change" + eol +
                        "how the game plays. There is no Goal of the game until someone plays one." + eol + eol + eol + eol +
                        "On your turn, draw the number of cards required, play the number of cards required," + eol +
                        "Discard down to the current Hand Limit (if any) and Keeper Limit (if any)." + eol + eol +
                        "The game will continue until one player meets the conditions of the current Goal."
        );
        playGame = new JButton("Play Game!");
        pane = new JPanel();

        Container container = this.getContentPane();
        container.setBackground(Color.WHITE);
        ImageIcon image = new ImageIcon("Card Images/_CARD BACK.jpg");
        JLabel j = new JLabel(" ", image, JLabel.CENTER);

        pane.add(j);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(pane);
        pane.add(instructions);
        //pane.add(playButton);

        playGame.addActionListener(this);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(instructions);
        southPanel.add(playGame);
        pane.add(BorderLayout.SOUTH, southPanel );

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[]args){
        Intro intro = new Intro();
    }

}