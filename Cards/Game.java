import java.util.ArrayList;

public class Game{
    private Table table;
    
    public Game(){
        table = new Table();
        table.addPlayer(new Player());
        table.addPlayer(new Player());

    }
    
    public Game(int playerNum){
        table = new Table();
        for (int i = 0; i < playerNum; i++){
            table.addPlayer(new Player());
        }
    }
    
    public String toString(){
        return table.toString();
    }
    
    public static void main(String[]args){
        Game g = new Game();
        System.out.println(g);
    }
    
}