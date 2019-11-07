package Model;

public class Battle {
    private Chara player;
    private Chara opponent;
    private String outcome;

    public Battle(Chara player, Chara opponent) {
        this.player = player;
        this.opponent = opponent;
    }


    public void fight() {
        player.setHealth(50);
        opponent.setHealth(50);

        int roundsPassed = 0;

        while (player.getHealth() > 0 && opponent.getHealth() > 0 && roundsPassed <50) {     //While both combatants are alive, and fifty rounds haven't passed
            //fight!

            Round diceToss = new Round(player.getName(), player.getAttack(), player.getDefense(), opponent.getName(), opponent.getAttack(), opponent.getDefense());

            player.reduceHealthBy(diceToss.getOpponentDealsDamage());
            opponent.reduceHealthBy(diceToss.getPlayerDealsDamage());

            System.out.println(diceToss.getRoundMessage());
            roundsPassed++;
        }


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
            if(player.getHealth() > opponent.getHealth()){
                System.out.println("After comparing wounds and blood spills, the combatants agree that " + player.getName() + " won on technical terms.");
                outcome = "victory";
            } else {
                System.out.println("After comparing wounds and blood spills, the combatants agree that " + opponent.getName() + " won on technical terms.");
                outcome = "defeat";
            }

        }
    }


    public String getOutcome() {
        return outcome;
    }

}
