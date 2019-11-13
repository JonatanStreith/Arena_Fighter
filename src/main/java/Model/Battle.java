package Model;

import jonst.App;

public class Battle {
    private Chara player;
    private Chara opponent;
    private String outcome;
    private int roundsPassed = 0;
    private StringBuilder battleLog;

    public Battle(Chara player, Chara opponent) {
        this.player = player;
        this.opponent = opponent;
        battleLog = new StringBuilder();        //Logs the outcome of each round.

        player.setHealth(player.getMaxHealth());    //Heal up to max


        while (player.getHealth() > 0 && opponent.getHealth() > 0 && roundsPassed < 50) {     //While both combatants are alive, and fifty rounds haven't passed
            //fight!

            Round diceToss = new Round(player, opponent);


            if(diceToss.isPlayerHits())
                opponent.reduceHealthBy(diceToss.getPlayerDealsDamage());
            if(diceToss.isOpponentHits())
                player.reduceHealthBy(diceToss.getOpponentDealsDamage());


            battleLog.append(diceToss.getRoundMessage());

            roundsPassed++;
        }

        System.out.println(battleLog);

        determineOutcome();
    }


    public void determineOutcome() {

        if (player.getHealth() < 1 && opponent.getHealth() < 1) {
            System.out.println("It's a double knockout!");
            outcome = "doubledefeat";
        } else if (opponent.getHealth() < 1) {

            System.out.println(player.getName() + " has defeated " + opponent.getName() + "!");
            outcome = "victory";

        } else if (player.getHealth() < 1) {

            System.out.println(player.getName() + " was slain...");
            outcome = "defeat";
        } else {
            System.out.println("This match is taking too long, and the audience begins to riot!");
            if (player.getHealth() > opponent.getHealth()) {
                System.out.println("After comparing wounds and blood spills, the combatants agree that " + player.getName() + " won on technical terms.");
                outcome = "victory";
            } else {
                System.out.println("After comparing wounds and blood spills, the combatants agree that " + opponent.getName() + " won on technical terms.");
                outcome = "defeat";
            }
        }

        App.askUserFor("\n[Press return to continue]\n");   //Just a pause.

    }


    public String getOutcome() {

        return outcome;
    }

}
