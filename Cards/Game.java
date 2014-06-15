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
    
    public void act(){
    }
    public void deathEffect(Player p, Card card){
	if(p.get/*stuff in play*/.size() == 1){
	    //give player option to discard Death
	    //return if player says yes
	}
	if(!card.getType().equals("Keeper") && !card.getType().equals("Creeper")){
	    return;
	}
	if(p.get.hasCard("Death")){
	    p.discard(table.getDiscard());
	} 
    }
	    
	
    public Player warEffect(Player p1, Player p2){
    	boolean hasPeace = (p1.getHand.hasCard("Peace") != -1);
    	boolean hasWar = (p1.getHand().hasCard("War") != -1);
        if(hasPeace == true && hasWar == true){
    	    p2.add();
    	    p1.remove(hand.hasCard("War"));
    	    return p2;
    	}else{
    	    return null;
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
