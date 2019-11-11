package Model;

public class Round {
    private int playerDice;
    private int opponentDice;
    private boolean playerHits = false;
    private boolean opponentHits = false;
    private int playerDealsDamage = 0;
    private int opponentDealsDamage = 0;
    private String roundMessage;

    public Round(String playerName, int playerAttack, int playerDefense, int playerWeapon, int playerArmor,
                 String opponentName, int opponentAttack, int opponentDefense, int opponentWeapon, int opponentArmor) {
        playerDice = (int) Math.ceil(Math.random() * 6);
        opponentDice = (int) Math.ceil(Math.random() * 6);

        if ((playerDice + playerAttack + playerWeapon) / 2 > (opponentDefense + opponentArmor)) {
            playerHits = true;
            playerDealsDamage = (playerDice + playerAttack + playerWeapon);
        }
        if ((opponentDice + opponentAttack + opponentWeapon) / 2 > (playerDefense + playerArmor)) {
            opponentHits = true;
            opponentDealsDamage = (opponentDice + opponentAttack + opponentWeapon);
        }

        roundMessage = message(playerName, opponentName);
    }


    public String message(String playerName, String opponentName) {
        String result;
        if (playerHits && opponentHits)
            result = playerName + " hits " + opponentName + " for " + playerDealsDamage +
                    " damage, but " + opponentName + " counters for " + opponentDealsDamage + "damage!";
        else if(playerHits)
            result = playerName + " hits " + opponentName + " for " + playerDealsDamage + " damage!";
        else if(opponentHits)
            result = opponentName + " hits " + playerName + " for " + opponentDealsDamage + " damage!";
        else
            result = "Both combatants miss!";

        return result;
    }


    public int getPlayerDealsDamage() {
        return playerDealsDamage;
    }

//    public void setPlayerDealsDamage(int playerDealsDamage) {
//        this.playerDealsDamage = playerDealsDamage;
//    }

    public int getOpponentDealsDamage() {
        return opponentDealsDamage;
    }

//    public void setOpponentDealsDamage(int opponentDealsDamage) {
//        this.opponentDealsDamage = opponentDealsDamage;
//    }

    public String getRoundMessage() {
        return roundMessage;
    }

}
