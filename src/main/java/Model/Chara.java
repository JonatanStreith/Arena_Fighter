package Model;

import jonst.App;

public class Chara {
    private String name;
    private int level;
    private int health;

    private StatBlock stats;
    private Inventory inventory;


    //    private int attack;
//    private int defense;



    //constructors

    public Chara(String name, int level, int strength, int dexterity, int constitution, int wisdom) {     //Gets specific character. Used for player.
        this.level = level;
        this.name = name;
        this.health = 50;
        stats = new StatBlock(strength, dexterity, constitution, wisdom);
        inventory = new Inventory(level);


        System.out.println("You start with a " + inventory.getWeapon().getDescription() +
                " and wear " + inventory.getArmor().getDescription() + ".");

    }

    public Chara() {        //Gets a random opponent. This probably won't be used.

        name = getVillainName();
        health = 50;
        stats = new StatBlock();
        inventory = new Inventory();
    }

    public Chara(int level) {        //Gets a random LEVELED opponent

        name = getVillainName();
        this.level = level;
        health = 50;
        stats = new StatBlock(level);
        inventory = new Inventory(level);

        System.out.print("You face " + name + ", a level " + level + " warrior, in the arena!\n");
        System.out.println("They have a " + inventory.getWeapon().getDescription() + " and wears " + inventory.getArmor().getDescription() + "!");
    }


    //functions

    public static String getVillainName() {

        String[] names = {
                "Grognak the Barbarian",
                "Blackthorne",
                "Silktongs of the Fell Order",
                "Donut Steel",
                "Five ducks in a man costume",
                "The Butcher",
                "Bob from Accounting"
        };


        return names[(int) Math.floor(Math.random() * names.length)];
    }

    public static int getMatchingLevel(int level) {

        int newLevel = level + (int) Math.floor(Math.random() * 7) - 3;   //Generates a variation of up to 3 in ether direction

        if (newLevel < 1) {
            newLevel = 1;
        }

        return newLevel;
    }

    public static Chara createPlayerCharacter() {

        String playerName = App.askUserFor("What is your name? ");
        int playerStrength = Integer.parseInt((App.askUserFor("Set your strength: ")));
        int playerDexterity = Integer.parseInt((App.askUserFor("Set your dexterity: ")));
        int playerConstitution = Integer.parseInt((App.askUserFor("Set your constitution: ")));
        int playerWisdom = Integer.parseInt((App.askUserFor("Set your wisdom: ")));

        return new Chara(playerName, 1, playerStrength, playerDexterity, playerConstitution, playerWisdom);
    }

    public void levelUp() {
        level++;
    }

    public void reduceHealthBy(int damage) {
        health -= damage;
    }

    public void getRandomLoot() {

        System.out.println("You receive spoils of victory!");

        boolean youGetWeapon = (Math.random() > 0.5) ? true : false;    //Fifty-fifty or so, you get weapon or armor

        if (youGetWeapon) {       //If you get a weapon
            Weapon newWeapon = new Weapon();
            String choice = App.askUserFor("You get a " + newWeapon.getDescription() + "! Do you want to use it instead of your current weapon? (y/n) (You have a " + inventory.getWeapon().getDescription() + ".)");

            if (choice.toLowerCase().equals("y")) {
                getInventory().setWeapon(newWeapon);
                System.out.println("You equip your new " + newWeapon.getType() + ".");
            } else {
                System.out.println("You decide to keep your old " + inventory.getWeapon().getType() + ".");
            }


        } else {                 //If you get an armor

            Armor newArmor = new Armor();
            String choice = App.askUserFor("You get a " + newArmor.getDescription() + "! Do you want to use it instead of your current armor? (y/n) (You have a " + inventory.getArmor().getDescription() + ".)");

            if (choice.toLowerCase().equals("y")) {
                getInventory().setArmor(newArmor);
                System.out.println("You equip your new " + newArmor.getType() + ".");
            } else {
                System.out.println("You decide to keep your old " + inventory.getArmor().getType() + ".");
            }
        }
    }

    public void claimLoot(Chara player, Chara opponent) {
        System.out.println("You may claim your opponent's weapon (a " + opponent.getInventory().getWeapon().getDescription() + "), or their armor (a " + opponent.getInventory().getArmor().getDescription() + ").");
        System.out.println("(You have a "  + player.getInventory().getWeapon().getDescription() + " and a " + player.getInventory().getArmor().getDescription() + ".)");

        String choice = App.askUserFor("Which do you choose? (w/a)?");

        switch (choice.toLowerCase()) {
            case "w":
                System.out.println("You claim your foe's " + opponent.getInventory().getWeapon().getType() + ".");
                player.getInventory().setWeapon(opponent.getInventory().getWeapon());
                break;

            case "a":
                System.out.println("You take your foe's " + opponent.getInventory().getArmor().getType() + " for yourself.");
                player.getInventory().setArmor(opponent.getInventory().getArmor());
                break;

            default:
                System.out.println("You decide you prefer your own gear for now.");
                break;

        }


    }


    public boolean victory(Chara player, Chara opponent) {
        levelUp();

        if (App.askUserFor("Do you want to continue? ").equals("y")) {
            claimLoot(player, opponent);
            //getRandomLoot();
            return true;

        } else {
            System.out.println("You decide to get out while the getting's good. You reached level " + level + " before retiring.");
            return false;
        }


    }

    public boolean defeat() {
        System.out.println("You have died. You reached level " + level + " before perishing.");
        return false;
    }


//Getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public StatBlock getStats() {
        return stats;
    }

    public void setStats(StatBlock stats) {
        this.stats = stats;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

