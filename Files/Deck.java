import java.util.Collections;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> deck;

    //all the cards!
    public static final Card BRAIN = new Card("Brain", "Keeper", "./Card Images/BRAIN.jpg");
    public static final Card BREAD = new Card("Bread", "Keeper", "./Card Images/BREAD.jpg");
    public static final Card CHOCOLATE = new Card("Chocolate", "Keeper", "./Card Images/CHOCOLATE.jpg");
    public static final Card COOKIES = new Card("Cookies", "Keeper", "./Card Images/COOKIES.jpg");
    public static final Card COSMOS = new Card("Cosmos", "Keeper", "./Card Images/COSMOS.jpg");
    public static final Card DREAMS = new Card("Dreams", "Keeper", "./Card Images/DREAMS.jpg");
    public static final Card LOVE = new Card("Love", "Keeper", "./Card Images/LOVE.jpg");
    public static final Card MILK = new Card("Milk", "Keeper", "./Card Images/MILK.jpg");
    public static final Card MONEY = new Card("Money", "Keeper", "./Card Images/MONEY.jpg");
    public static final Card MOON = new Card("Moon", "Keeper", "./Card Images/THE MOON.jpg");
    public static final Card PEACE = new Card("Peace", "Keeper", "./Card Images/PEACE.jpg");
    public static final Card ROCKET = new Card("Rocket", "Keeper", "./Card Images/ROCKET.jpg");
    public static final Card SLEEP = new Card("Sleep", "Keeper", "./Card Images/SLEEP.jpg");
    public static final Card SUN = new Card("Sun", "Keeper", "./Card Images/SUN.jpg");
    public static final Card TELEVISION = new Card("Television", "Keeper", "./Card Images/TELEVISION.jpg");
    public static final Card TIME = new Card("Time", "Keeper", "./Card Images/TIME.jpg");
    public static final Card TOASTER = new Card("Toaster", "Keeper", "./Card Images/TOASTER.jpg");
    public static final Card EYE = new Card("Eye", "Keeper", "./Card Images/EYE.jpg");
    public static final Card PARTY = new Card("Party", "Keeper", "./Card Images/THE PARTY.jpg");
    public static final Card WAR = new Card("War", "Creeper", "./Card Images/WAR.jpg");
    public static final Card DEATH = new Card("Death", "Creeper", "./Card Images/DEATH.jpg");
    public static final Card TAXES = new Card("Taxes", "Creeper", "./Card Images/TAXES.jpg");
    public static final Card POTATO = new Card("Radioactive Potato", "Creeper", "./Card Images/RADIOACTIVE POTATO.jpg");
    public static final Card JACKPOT = new Card("Jackpot", "Action", "./Card Images/JACKPOT.jpg");
    public static final Card DISCARDANDDRAW = new Card("Discard and Draw", "Action", "./Card Images/DISCARD AND DRAW.jpg");
    public static final Card DRAW2USE2 = new Card("Draw 2 and use 'em", "Action", "./Card Images/DRAW 2 AND USE 'EM.jpg");
    public static final Card DRAW3USE2 = new Card("Draw 3. Play 2 of them", "Action", "./Card Images/DRAW 3, PLAY 2 OF THEM.jpg");
    public static final Card EVERY1 = new Card("Everybody Gets 1", "Action", "./Card Images/EVERYBODY GETS 1.jpg");
    public static final Card EXCHANGE = new Card("Exchange Keepers", "Action", "./Card Images/EXCHANGE KEEPERS.jpg");
    public static final Card DOAGAIN = new Card("Let's Do That Again", "Action", "./Card Images/LET'S DO THAT AGAIN.jpg");
    public static final Card SIMPLIFY = new Card("Let's Simplify", "Action", "./Card Images/LET'S SIMPLIFY.jpg");
    public static final Card NOLIMITS = new Card("No Limits", "Action", "./Card Images/NO LIMITS.jpg");
    public static final Card ROTATE = new Card("Rotate Hands", "Action", "./Card Images/ROTATE HANDS.jpg");
    public static final Card RESET = new Card("Rules Reset", "Action", "./Card Images/RULES RESET.jpg");
    public static final Card TURN2 = new Card("Take Another Turn", "Action", "./Card Images/TAKE ANOTHER TURN.jpg");
    public static final Card TAXATION = new Card("Taxation", "Action", "./Card Images/TAXATION.jpg");
    public static final Card TRADEHANDS = new Card("Trade Hands", "Action", "./Card Images/TRADE HANDS.jpg");
    public static final Card TRASHNR = new Card("Trash a New Rule", "Action", "./Card Images/TRASH A NEW RULE.jpg");
    public static final Card USETAKE = new Card("Use What You Take", "Action", "./Card Images/USE WHAT YOU TAKE.jpg");
    public static final Card SWEEPER = new Card("Creeper Sweeper", "Action", "./Card Images/CREEPER SWEEPER.jpg");
    public static final Card TRASHSOMETHING = new Card("Trash Something", "Action", "./Card Images/TRASH SOMETHING.jpg");
    public static final Card STEALSOMETHING = new Card("Steal Something", "Action", "./Card Images/STEAL SOMETHING.jpg");
    public static final Card MIX = new Card("Mix It All Up", "Action", "./Card Images/MIX IT ALL UP.jpg");
    public static final Card DRAW2 = new Card("Draw 2", "New Rule", "./Card Images/DRAW 2.jpg");
    public static final Card DRAW3 = new Card("Draw 3", "New Rule", "./Card Images/DRAW 3.jpg");
    public static final Card DRAW4 = new Card("Draw 4", "New Rule", "./Card Images/DRAW 4.jpg");
    public static final Card DRAW5 = new Card("Draw 5", "New Rule", "./Card Images/DRAW 5.jpg");
    public static final Card PLAY2 = new Card("Play 2", "New Rule", "./Card Images/PLAY 2.jpg");
    public static final Card PLAY3 = new Card("Play 3", "New Rule", "./Card Images/PLAY 3.jpg");
    public static final Card PLAY4 = new Card("Play 4", "New Rule", "./Card Images/PLAY 4.jpg");
    public static final Card PLAYALL = new Card("Play All", "New Rule", "./Card Images/PLAY ALL.jpg");
    public static final Card HL0 = new Card("Hand Limit 0", "New Rule", "./Card Images/HAND LIMIT 0.jpg");
    public static final Card HL1 = new Card("Hand Limit 1", "New Rule", "./Card Images/HAND LIMIT 1.jpg");
    public static final Card HL2 = new Card("Hand Limit 2", "New Rule", "./Card Images/HAND LIMIT 2.jpg");
    public static final Card KL2 = new Card("Keeper Limit 2", "New Rule", "./Card Images/KEEPER LIMIT 2.jpg");
    public static final Card KL3 = new Card("Keeper Limit 3", "New Rule", "./Card Images/KEEPER LIMIT 3.jpg");
    public static final Card KL4 = new Card("Keeper Limit 4", "New Rule", "./Card Images/KEEPER LIMIT 4.jpg");
    public static final Card DOUBLEAGENDA = new Card("Double Agenda", "New Rule", "./Card Images/DOUBLE AGENDA.jpg");
    public static final Card FPRANDOM = new Card("First Play Random", "New Rule", "./Card Images/FIRST PLAY RANDOM.jpg");
    public static final Card NOHAND = new Card("No-Hand Bonus", "New Rule", "./Card Images/NO-HAND BONUS.jpg");
    public static final Card POOR = new Card("Poor Bonus", "New Rule", "./Card Images/POOR BONUS.jpg");
    public static final Card RICH = new Card("Rich Bonus", "New Rule", "./Card Images/RICH BONUS.jpg");
    public static final Card INFLATION = new Card("Inflation", "New Rule", "./Card Images/INFLATION.jpg");
    public static final Card PARTYBONUS = new Card("Party Bonus", "New Rule", "./Card Images/PARTY BONUS.jpg");
    public static final Card GETONWITHIT = new Card("Get On With It!", "New Rule", "./Card Images/GET ON WITH IT!.jpg");
    public static final Card SILVER = new Card("Silver Lining", "New Rule", "./Card Images/SILVER LINING.jpg");
    public static final Card NEEDPOTATO = new Card("You Also Need a Baked Potato", "New Rule", "./Card Images/YOU ALSO NEED A POTATO.jpg");
    public static final Card TENCARDS = new Card("10 Cards In Hand", "Goal", "./Card Images/10 CARDS IN HAND.jpg");
    public static final Card FIVEKEEPERS = new Card("5 Keepers", "Goal", "./Card Images/5 KEEPERS.jpg");
    public static final Card ALLLOVE = new Card("All You Need Is Love", "Goal", "./Card Images/ALL YOU NEED IS LOVE.jpg");
    public static final Card APPLIANCES = new Card("Appliances", "Goal", "./Card Images/APPLIANCES.jpg");
    public static final Card BAKED = new Card("Baked Goods", "Goal", "./Card Images/BAKED GOODS.jpg");
    public static final Card BEDTIME = new Card("Bed Time", "Goal", "./Card Images/BED TIME.jpg");
    public static final Card BRAINNOTV = new Card("Brain (no TV)", "Goal", "./Card Images/BRAIN NO TV.jpg");
    public static final Card CHOCOLATECOOKIES = new Card("Chocolate Cookies", "Goal", "./Card Images/CHOCOLATE COOKIES.jpg");
    public static final Card CHOCOLATEMILK = new Card("Chocolate Milk", "Goal", "./Card Images/CHOCOLATE MILK.jpg");
    public static final Card DEATHBYCHOCOLATE = new Card("Death by Chocolate", "Goal", "./Card Images/DEATH BY CHOCOLATE.jpg");
    public static final Card DREAMLAND = new Card("Dreamland", "Goal", "./Card Images/DREAMLAND.jpg");
    public static final Card HEARTSANDMINDS = new Card("Hearts and Minds", "Goal", "./Card Images/HEARTS AND MINDS.jpg");
    public static final Card HIPPYISM = new Card("Hippyism", "Goal", "./Card Images/HIPPYISM.jpg");
    public static final Card MILKANDCOOKIES = new Card("Milk and Cookies", "Goal", "./Card Images/MILK AND COOKIES.jpg");
    public static final Card NIGHTANDDAY = new Card("Night and Day", "Goal", "./Card Images/NIGHT AND DAY.jpg");
    public static final Card PEACENOWAR = new Card("Peace (no War)", "Goal", "./Card Images/PEACE NO WAR.jpg");
    public static final Card ROCKETSCIENCE = new Card("Rocket Science", "Goal", "./Card Images/ROCKET SCIENCE.jpg");
    public static final Card ROCKETTOMOON = new Card("Rocket to the Moon", "Goal", "./Card Images/ROCKET TO THE MOON.jpg");
    public static final Card SQUISHYCHOCOLATE = new Card("Squishy Chocolate", "Goal", "./Card Images/SQUISHY CHOCOLATE.jpg");
    public static final Card TIMEISMONEY = new Card("Time is Money", "Goal", "./Card Images/TIME IS MONEY.jpg");
    public static final Card TOAST = new Card("Toast", "Goal", "./Card Images/TOAST.jpg");
    public static final Card WARDEATH = new Card("War = Death", "Goal", "./Card Images/WAR = DEATH.jpg");
    public static final Card WINNINGLOTTERY = new Card("Winning the Lottery", "Goal", "./Card Images/WINNING THE LOTTERY.jpg");
    public static final Card MINDSEYE = new Card("Mind's Eye", "Goal", "./Card Images/MIND'S EYE.jpg");
    public static final Card DOUGH = new Card("Dough", "Goal", "./Card Images/DOUGH.jpg");
    public static final Card ALLCERTAIN = new Card("All That is Certain", "Goal", "./Card Images/ALL THAT IS CERTAIN.jpg");
    public static final Card INTERSTELLAR = new Card("Interstellar Spacecraft", "Goal", "./Card Images/INTERSTELLAR SPACECRAFT.jpg");
    public static final Card STARGAZING = new Card("Star Gazing", "Goal", "./Card Images/STAR GAZING.jpg");
    public static final Card PARTYSNACKS = new Card("Party Snacks", "Goal", "./Card Images/PARTY SNACKS.jpg");


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
