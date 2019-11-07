package Model;

public class Round {
    private int playerDice;
    private int opponentDice;
    private boolean playerHits = false;
    private boolean opponentHits = false;
    private int playerDealsDamage = 0;
    private int opponentDealsDamage = 0;
    private String roundMessage;

    public Round(String playerName, int playerAttack, int playerDefense, String opponentName, int opponentAttack, int opponentDefense) {
        playerDice = (int) Math.ceil(Math.random() * 6);
        opponentDice = (int) Math.ceil(Math.random() * 6);

        if ((playerDice + playerAttack) / 2 > opponentDefense) {
            playerHits = true;
            playerDealsDamage = (playerDice + playerAttack);
        }
        if ((opponentDice + opponentAttack) / 2 > playerDefense) {
            opponentHits = true;
            opponentDealsDamage = (opponentDice + opponentAttack);
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

    public void setPlayerDealsDamage(int playerDealsDamage) {
        this.playerDealsDamage = playerDealsDamage;
    }

    public int getOpponentDealsDamage() {
        return opponentDealsDamage;
    }

    public void setOpponentDealsDamage(int opponentDealsDamage) {
        this.opponentDealsDamage = opponentDealsDamage;
    }

    public String getRoundMessage() {
        return roundMessage;
    }

}
