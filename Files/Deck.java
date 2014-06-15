import java.util.Collections;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> deck;

    //all the cards!
    public static final Card BRAIN = new Card("Brain", "Keeper");
    public static final Card BREAD = new Card("Bread", "Keeper");
    public static final Card CHOCOLATE = new Card("Chocolate", "Keeper");
    public static final Card COOKIES = new Card("Cookies", "Keeper");
    public static final Card COSMOS = new Card("Cosmos", "Keeper");
    public static final Card DREAMS = new Card("Dreams", "Keeper");
    public static final Card LOVE = new Card("Love", "Keeper");
    public static final Card MILK = new Card("Milk", "Keeper");
    public static final Card MONEY = new Card("Money", "Keeper");
    public static final Card MOON = new Card("Moon", "Keeper");
    public static final Card PEACE = new Card("Peace", "Keeper");
    public static final Card ROCKET = new Card("Rocket", "Keeper");
    public static final Card SLEEP = new Card("Sleep", "Keeper");
    public static final Card SUN = new Card("Sun", "Keeper");
    public static final Card TELEVISION = new Card("Television", "Keeper");
    public static final Card TIME = new Card("Time", "Keeper");
    public static final Card TOASTER = new Card("Toaster", "Keeper");
    public static final Card EYE = new Card("Eye", "Keeper");
    public static final Card PARTY = new Card("Party", "Keeper");
    public static final Card WAR = new Card("War", "Creeper");
    public static final Card DEATH = new Card("Death", "Creeper");
    public static final Card TAXES = new Card("Taxes", "Creeper");
    public static final Card POTATO = new Card("Radioactive Potato", "Creeper");
    public static final Card JACKPOT = new Card("Jackpot", "Action");
    public static final Card DISCARDANDDRAW = new Card("Discard and Draw", "Action");
    public static final Card DRAW2USE2 = new Card("Draw 2 and use 'em", "Action");
    public static final Card DRAW3USE2 = new Card("Draw 3. Play 2 of them", "Action");
    public static final Card EVERY1 = new Card("Everybody Gets 1", "Action");
    public static final Card EXCHANGE = new Card("Exchange Keepers", "Action");
    public static final Card DOAGAIN = new Card("Let's Do That Again", "Action");
    public static final Card SIMPLIFY = new Card("Let's Simplify", "Action");
    public static final Card NOLIMITS = new Card("No Limits", "Action");
    public static final Card ROTATE = new Card("Rotate Hands", "Action");
    public static final Card RESET = new Card("Rules Reset", "Action");
    public static final Card TURN2 = new Card("Take Another Turn", "Action");
    public static final Card TAXATION = new Card("Taxation", "Action");
    public static final Card TRADEHANDS = new Card("Trade Hands", "Action");
    public static final Card TRASHNR = new Card("Trash a New Rule", "Action");
    public static final Card USETAKE = new Card("Use What You Take", "Action");
    public static final Card SWEEPER = new Card("Creeper Sweeper", "Action");
    public static final Card TRASHSOMETHING = new Card("Trash Something", "Action");
    public static final Card STEALSOMETHING = new Card("Steal Something", "Action");
    public static final Card MIX = new Card("Mix It All Up", "Action");
    public static final Card TODAY = new Card("Today's Special!", "Action");
    public static final Card TRASHDAY = new Card("It's Trash Day", "Action");
    public static final Card DRAW2 = new Card("Draw 2", "New Rule");
    public static final Card DRAW3 = new Card("Draw 3", "New Rule");
    public static final Card DRAW4 = new Card("Draw 4", "New Rule");
    public static final Card DRAW5 = new Card("Draw 5", "New Rule");
    public static final Card PLAY2 = new Card("Play 2", "New Rule");
    public static final Card PLAY3 = new Card("Play 3", "New Rule");
    public static final Card PLAY4 = new Card("Play 4", "New Rule");
    public static final Card PLAYALL = new Card("Play All", "New Rule");
    public static final Card HL0 = new Card("Hand Limit 0", "New Rule");
    public static final Card HL1 = new Card("Hand Limit 1", "New Rule");
    public static final Card HL2 = new Card("Hand Limit 2", "New Rule");
    public static final Card KL2 = new Card("Keeper Limit 2", "New Rule");
    public static final Card KL3 = new Card("Keeper Limit 3", "New Rule");
    public static final Card KL4 = new Card("Keeper Limit 4", "New Rule");
    public static final Card DOUBLEAGENDA = new Card("Double Agenda", "New Rule");
    public static final Card FPRANDOM = new Card("First Play Random", "New Rule");
    public static final Card NOHAND = new Card("No-Hand Bonus", "New Rule");
    public static final Card POOR = new Card("Poor Bonus", "New Rule");
    public static final Card RICH = new Card("Rich Bonus", "New Rule");
    public static final Card INFLATION = new Card("Inflation", "New Rule");
    public static final Card PARTYBONUS = new Card("Party Bonus", "New Rule");
    public static final Card GETONWITHIT = new Card("Get On With It!", "New Rule");
    public static final Card SILVER = new Card("Silver Lining", "New Rule");
    public static final Card NEEDPOTATO = new Card("You Also Need a Potato", "New Rule");
    public static final Card TENCARDS = new Card("10 Cards In Hand", "Goal");
    public static final Card FIVEKEEPERS = new Card("5 Keepers", "Goal");
    public static final Card ALLLOVE = new Card("All You Need Is Love", "Goal");
    public static final Card APPLIANCES = new Card("Appliances", "Goal");
    public static final Card BAKED = new Card("Baked Goods", "Goal");
    public static final Card BEDTIME = new Card("Bed Time", "Goal");
    public static final Card BRAINNOTV = new Card("Brain (no TV)", "Goal");
    public static final Card CHOCOLATECOOKIES = new Card("Chocolate Cookies", "Goal");
    public static final Card CHOCOLATEMILK = new Card("Chocolate Milk", "Goal");
    public static final Card DEATHBYCHOCOLATE = new Card("Death by Chocolate", "Goal");
    public static final Card DREAMLAND = new Card("Dreamland", "Goal");
    public static final Card HEARTSANDMINDS = new Card("Hearts and Minds", "Goal");
    public static final Card HIPPYISM = new Card("Hippyism", "Goal");
    public static final Card MILKANDCOOKIES = new Card("Milk and Cookies", "Goal");
    public static final Card NIGHTANDDAY = new Card("Night and Day", "Goal");
    public static final Card PEACENOWAR = new Card("Peace (no War)", "Goal");
    public static final Card ROCKETSCIENCE = new Card("Rocket Science", "Goal");
    public static final Card ROCKETTOMOON = new Card("Rocket to the Moon", "Goal");
    public static final Card SQUISHYCHOCOLATE = new Card("Squishy Chocolate", "Goal");
    public static final Card TIMEISMONEY = new Card("Time is Money", "Goal");
    public static final Card TOAST = new Card("Toast", "Goal");
    public static final Card WARDEATH = new Card("War = Death", "Goal");
    public static final Card WINNINGLOTTERY = new Card("Winning the Lottery", "Goal");
    public static final Card MINDSEYE = new Card("Mind's Eye", "Goal");
    public static final Card DOUGH = new Card("Dough", "Goal");
    public static final Card ALLCERTAIN = new Card("All That is Certain", "Goal");
    public static final Card INTERSTELLAR = new Card("Interstellar Spacecraft", "Goal");
    public static final Card STARGAZING = new Card("Star Gazing", "Goal");
    public static final Card PARTYSNACKS = new Card("Party Snacks", "Goal");


    public Deck(){
	    deck = new ArrayList<Card>(98); //this is a queue
	    //insert all of the different cards

        deck.add(BRAIN);
        deck.add(BREAD);
        deck.add(CHOCOLATE);
        deck.add(COOKIES);
        deck.add(COSMOS);
        deck.add(DREAMS);
        deck.add(LOVE);
        deck.add(MILK);
        deck.add(MONEY);
        deck.add(MOON);
        deck.add(PEACE);
        deck.add(ROCKET);
        deck.add(SLEEP);
        deck.add(SUN);
        deck.add(TELEVISION);
        deck.add(TIME);
        deck.add(TOASTER);
        deck.add(EYE);
        deck.add(PARTY);
        deck.add(WAR);
        deck.add(DEATH);
        deck.add(TAXES);
        deck.add(POTATO);
        deck.add(JACKPOT);
        deck.add(DISCARDANDDRAW);
        deck.add(DRAW2USE2);
        deck.add(DRAW3USE2);
        deck.add(EVERY1);
        deck.add(EXCHANGE);
        deck.add(DOAGAIN);
        deck.add(SIMPLIFY);
        deck.add(NOLIMITS);
        deck.add(ROTATE);
        deck.add(RESET);
        deck.add(TURN2);
        deck.add(TRADEHANDS);
        deck.add(TAXATION);
        deck.add(TRASHNR);
        deck.add(USETAKE);
        deck.add(SWEEPER);
        deck.add(TRASHSOMETHING);
        deck.add(STEALSOMETHING);
        deck.add(MIX);
        deck.add(TODAY);
        deck.add(TRASHDAY);
        deck.add(DRAW2);
        deck.add(DRAW3);
        deck.add(DRAW4);
        deck.add(DRAW5);
        deck.add(PLAY2);
        deck.add(PLAY3);
        deck.add(PLAY4);
        deck.add(PLAYALL);
        deck.add(HL0);
        deck.add(HL1);
        deck.add(HL2);
        deck.add(KL2);
        deck.add(KL3);
        deck.add(KL4);
        deck.add(DOUBLEAGENDA);
        deck.add(FPRANDOM);
        deck.add(NOHAND);
        deck.add(POOR);
        deck.add(RICH);
        deck.add(INFLATION);
        deck.add(PARTYBONUS);
        deck.add(GETONWITHIT);
        deck.add(SILVER);
        deck.add(NEEDPOTATO);
        deck.add(TENCARDS);
        deck.add(FIVEKEEPERS);
        deck.add(ALLLOVE);
        deck.add(APPLIANCES);
        deck.add(BEDTIME);
        deck.add(BRAINNOTV);
        deck.add(CHOCOLATECOOKIES);
        deck.add(CHOCOLATEMILK);
        deck.add(DEATHBYCHOCOLATE);
        deck.add(DREAMLAND);
        deck.add(HEARTSANDMINDS);
        deck.add(HIPPYISM);
        deck.add(MILKANDCOOKIES);
        deck.add(NIGHTANDDAY);
        deck.add(PEACENOWAR);
        deck.add(ROCKETSCIENCE);
        deck.add(ROCKETTOMOON);
        deck.add(SQUISHYCHOCOLATE);
        deck.add(TIMEISMONEY);
        deck.add(TOAST);
        deck.add(WARDEATH);
        deck.add(WINNINGLOTTERY);
        deck.add(MINDSEYE);
        deck.add(DOUGH);
        deck.add(ALLCERTAIN);
        deck.add(INTERSTELLAR);
        deck.add(STARGAZING);
        deck.add(PARTYSNACKS);


	    Collections.shuffle(deck);
    }
    
    public void reshuffle(Discard dis){
        for(int i = 0; i < dis.size(); i ++){
            deck.add(dis.get(i));
        }
        Collections.shuffle(deck);
    }

    public int size(){
        return deck.size();
    }

    public Card remove(){ //draw 1st card
        return deck.remove(0);
    }

    public String toString(){
        String ret = "" + deck.get(0).getName();
        for(int i = 1; i < deck.size(); i ++){
            ret +=", " + deck.get(i).getName();
        }
        return ret +  "\n";
    }

/*

    //ALL THE ACCESSORS!!!!!!!!1!!
    public static Card getBrain() {
        return BRAIN;
    }

    public static Card getBread() {
        return BREAD;
    }

    public static Card getChocolate() {
        return CHOCOLATE;
    }

    public static Card getCookies() {
        return COOKIES;
    }

    public static Card getCosmos() {
        return COSMOS;
    }

    public static Card getDreams() {
        return DREAMS;
    }

    public static Card getLove() {
        return LOVE;
    }

    public static Card getMilk() {
        return MILK;
    }

    public static Card getMoney() {
        return MONEY;
    }

    public static Card getMoon() {
        return MOON;
    }

    public static Card getPeace() {
        return PEACE;
    }

    public static Card getRocket() {
        return ROCKET;
    }

    public static Card getSleep() {
        return SLEEP;
    }

    public static Card getSun() {
        return SUN;
    }

    public static Card getTelevision() {
        return TELEVISION;
    }

    public static Card getTime() {
        return TIME;
    }

    public static Card getToaster() {
        return TOASTER;
    }

    public static Card getEye() {
        return EYE;
    }

    public static Card getParty() {
        return PARTY;
    }

    public static Card getWar() {
        return WAR;
    }

    public static Card getDeath() {
        return DEATH;
    }

    public static Card getTaxes() {
        return TAXES;
    }

    public static Card getPotato() {
        return POTATO;
    }

    public static Card getJackpot() {
        return JACKPOT;
    }

    public static Card getDiscardanddraw() {
        return DISCARDANDDRAW;
    }

    public static Card getDraw2use2() {
        return DRAW2USE2;
    }

    public static Card getDraw3use2() {
        return DRAW3USE2;
    }

    public static Card getEvery1() {
        return EVERY1;
    }

    public static Card getExchange() {
        return EXCHANGE;
    }

    public static Card getDoagain() {
        return DOAGAIN;
    }

    public static Card getSimplify() {
        return SIMPLIFY;
    }

    public static Card getNolimits() {
        return NOLIMITS;
    }

    public static Card getRotate() {
        return ROTATE;
    }

    public static Card getReset() {
        return RESET;
    }

    public static Card getTurn2() {
        return TURN2;
    }

    public static Card getTaxation() {
        return TAXATION;
    }

    public static Card getTradehands() {
        return TRADEHANDS;
    }

    public static Card getTrashnr() {
        return TRASHNR;
    }

    public static Card getUsetake() {
        return USETAKE;
    }

    public static Card getSweeper() {
        return SWEEPER;
    }

    public static Card getTrashsomething() {
        return TRASHSOMETHING;
    }

    public static Card getStealsomething() {
        return STEALSOMETHING;
    }

    public static Card getMix() {
        return MIX;
    }

    public static Card getToday() {
        return TODAY;
    }

    public static Card getTrashday() {
        return TRASHDAY;
    }

    public static Card getDraw2() {
        return DRAW2;
    }

    public static Card getDraw3() {
        return DRAW3;
    }

    public static Card getDraw4() {
        return DRAW4;
    }

    public static Card getDraw5() {
        return DRAW5;
    }

    public static Card getPlay2() {
        return PLAY2;
    }

    public static Card getPlay3() {
        return PLAY3;
    }

    public static Card getPlay4() {
        return PLAY4;
    }

    public static Card getPlayall() {
        return PLAYALL;
    }

    public static Card getHl0() {
        return HL0;
    }

    public static Card getHl1() {
        return HL1;
    }

    public static Card getHl2() {
        return HL2;
    }

    public static Card getKl2() {
        return KL2;
    }

    public static Card getKl3() {
        return KL3;
    }

    public static Card getKl4() {
        return KL4;
    }

    public static Card getDoubleAgenda() {
        return DOUBLEAGENDA;
    }

    public static Card getFPRandom() {
        return FPRANDOM;
    }

    public static Card getNoHand() {
        return NOHAND;
    }

    public static Card getPoor() {
        return POOR;
    }

    public static Card getRich() {
        return RICH;
    }

    public static Card getInflation() {
        return INFLATION;
    }

    public static Card getPartyBonus() {
        return PARTYBONUS;
    }

    public static Card getGetOnWithIt() {
        return GETONWITHIT;
    }

    public static Card getSilver() {
        return SILVER;
    }

    public static Card getNeedPotato() {
        return NEEDPOTATO;
    }

    public static Card getTenCards() {
        return TENCARDS;
    }

    public static Card getFiveKeepers() {
        return FIVEKEEPERS;
    }

    public static Card getAllLove() {
        return ALLLOVE;
    }

    public static Card getAppliances() {
        return APPLIANCES;
    }

    public static Card getBaked() {
        return BAKED;
    }

    public static Card getBedTime() {
        return BEDTIME;
    }

    public static Card getBrainNoTV() {
        return BRAINNOTV;
    }

    public static Card getChocolateCookies() {
        return CHOCOLATECOOKIES;
    }

    public static Card getChocolateMilk() {
        return CHOCOLATEMILK;
    }

    public static Card getDeathByChocolate() {
        return DEATHBYCHOCOLATE;
    }

    public static Card getDreamland() {
        return DREAMLAND;
    }

    public static Card getHeartsAndMinds() {
        return HEARTSANDMINDS;
    }

    public static Card getHippyism() {
        return HIPPYISM;
    }

    public static Card getMilkAndCookies() {
        return MILKANDCOOKIES;
    }

    public static Card getNightAndDay() {
        return NIGHTANDDAY;
    }

    public static Card getPeaceNoWar() {
        return PEACENOWAR;
    }

    public static Card getRocketScience() {
        return ROCKETSCIENCE;
    }

    public static Card getRocketToMoon() {
        return ROCKETTOMOON;
    }

    public static Card getSquishyChocolate() {
        return SQUISHYCHOCOLATE;
    }

    public static Card getTimeIsMoney() {
        return TIMEISMONEY;
    }

    public static Card getToast() {
        return TOAST;
    }

    public static Card getWarDeath() {
        return WARDEATH;
    }

    public static Card getWinninglottery() {
        return WINNINGLOTTERY;
    }

    public static Card getMindsEye() {
        return MINDSEYE;
    }

    public static Card getDough() {
        return DOUGH;
    }

    public static Card getAllCertain() {
        return ALLCERTAIN;
    }

    public static Card getInterstellar() {
        return INTERSTELLAR;
    }

    public static Card getStarGazing() {
        return STARGAZING;
    }

    public static Card getPartySnacks() {
        return PARTYSNACKS;
    }
*/


}
