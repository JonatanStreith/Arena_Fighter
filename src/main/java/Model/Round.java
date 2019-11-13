package Model;

public class Round {
    private Chara player;
    private Chara opponent;
    private int playerDice;
    private int opponentDice;
    private boolean playerHits = false;
    private boolean opponentHits = false;
    private int playerDealsDamage = 0;
    private int opponentDealsDamage = 0;
    private String roundMessage;

    public Round(Chara player, Chara opponent) {
        this.player = player;
        this.opponent = opponent;
        playerDice = (int) Math.ceil(Math.random() * 6);
        opponentDice = (int) Math.ceil(Math.random() * 6);

        if ((playerDice + player.getStats().getDexterity() + player.getInventory().getWeapon().getBonus()) / 2 > (opponent.getStats().getWisdom() + opponent.getInventory().getArmor().getBonus())) {
            playerHits = true;
            playerDealsDamage = (player.getStats().getStrength() - opponent.getStats().getConstitution() + player.getInventory().getWeapon().getBonus());
            playerDealsDamage = (playerDealsDamage < 1) ? 1 : playerDealsDamage;      //Check to avoid "negative damage"
        }
        if ((opponentDice + opponent.getStats().getDexterity() + opponent.getInventory().getWeapon().getBonus()) / 2 > (player.getStats().getWisdom() + player.getInventory().getArmor().getBonus())) {
            opponentHits = true;
            opponentDealsDamage = (opponent.getStats().getStrength() - player.getStats().getConstitution() + opponent.getInventory().getWeapon().getBonus());
            opponentDealsDamage = (opponentDealsDamage < 1) ? 1 : opponentDealsDamage;      //Check to avoid "negative damage"
        }

        roundMessage = message();
    }


    public String message() {
        String result;
        if (playerHits && opponentHits)
            result = dualStrikes();
        else if (playerHits)
            result = playerStrikes();
        else if (opponentHits)
            result = opponentStrikes();
        else
            result = bothMiss();

        return result;
    }

    public String dualStrikes() {

        String[] lines = {
                player.getName() + " hits " + opponent.getName() + " for " + playerDealsDamage + " damage, but " + opponent.getName() + " counters for " + opponentDealsDamage + " damage!",
                "Both fighters exchange a flurry of blows! " + player.getName() + " delivers " + playerDealsDamage + " to " + opponent.getName() + ", but takes " + opponentDealsDamage + " in return!",
                opponent.getName() + " strikes " + player.getName() + " for " + opponentDealsDamage + " damage, but leaves themselves open for a counterstrike, taking " + playerDealsDamage + " from " + player.getName()
        };

        return lines[(int) Math.floor(Math.random() * lines.length)];
    }


    public String playerStrikes() {
        String[] lines = {
                player.getName() + " slashes their foe, " + opponent.getName() + ", for " + playerDealsDamage + " damage!",
                player.getName() + " catches their opponent off-guard and delivers a devastating strike for " + playerDealsDamage + " damage!",
                player.getName() + " presses their advantage! The helpless " + opponent.getName() + " takes " + playerDealsDamage + " damage as they are mauled by the attack!"
        };

        return lines[(int) Math.floor(Math.random() * lines.length)];
    }

    public String opponentStrikes() {
        String[] lines = {
                opponent.getName() + " sneaks up from behind and stabs " + player.getName() + " for " + opponentDealsDamage + " damage!",
                opponent.getName() + " gets the better of their quarry, and savagely beats " + player.getName() + " for " + opponentDealsDamage + " damage!",
                opponent.getName() + " gets in a sharp blow, and causes " + opponentDealsDamage + " damage!"
        };

        return lines[(int) Math.floor(Math.random() * lines.length)];
    }

    public String bothMiss() {
        String[] lines = {
                opponent.getName() + " and " + player.getName() + " lock weapons for a drawn-out moment, and sparks fly!",
                player.getName() + " swings wildly, while " + opponent.getName() + " dodges out of the way!",
                opponent.getName() + " misses completely!",
                player.getName() + " misses completely!"
        };

        return lines[(int) Math.floor(Math.random() * lines.length)];
    }


    //Getters and Setters

    public int getPlayerDealsDamage() {
        return playerDealsDamage;
    }

    public int getOpponentDealsDamage() {
        return opponentDealsDamage;
    }

    public String getRoundMessage() {
        return roundMessage + "\n";
    }

    public boolean isPlayerHits() {
        return playerHits;
    }

    public boolean isOpponentHits() {
        return opponentHits;
    }

    public int getPlayerDice() {
        return playerDice;
    }

    public int getOpponentDice() {
        return opponentDice;
    }
}
