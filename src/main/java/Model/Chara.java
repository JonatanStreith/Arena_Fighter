package Model;

import jonst.App;

public class Chara {
    private String name;
    private String profession;

    private int level;
    private int maxHealth;
    private int health;


    private StatBlock stats;
    private Inventory inventory;


    //    private int attack;
//    private int defense;


    //constructors

    public Chara(String name, int level, StatBlock stats) {     //Gets specific character. Used for player.
        this.name = name;
        this.level = level;
        this.stats = stats;
        inventory = new Inventory(level);

        maxHealth = 20 + (stats.getConstitution() * 5);
        health = maxHealth;


        System.out.println("You are a " + stats.getProfession() + ". You start with a " + inventory.getWeapon().getDescription() +
                " and wear " + inventory.getArmor().getDescription() + ".");



    }



    public Chara(int level) {        //Gets a random LEVELED opponent

        name = getVillainName();
        this.level = getMatchingLevel(level);
        stats = getStats(getRandomProfession());
        inventory = new Inventory(level);

        maxHealth = 20 + (stats.getConstitution() * 5);
        health = maxHealth;

        System.out.print("You face " + name + ", a level " + level + " " + stats.getProfession() + ", in the arena!\n");
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
                "Bob from Accounting",
                "Gorgoflex the Unchained",
                "Truck-kun"
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

    public static String getRandomProfession() {
        String[] classes = {"F", "R", "C", "M", "B", "W", "U"};

        return classes[(int) Math.floor(Math.random() * classes.length)];
    }

    public static StatBlock getStats(String profession) {

        switch (profession.toUpperCase()) {
            case "F":
                //System.out.println("You have chosen: Fighter.");
                return new StatBlock("fighter", 6, 4, 4, 2);

            case "R":
                //System.out.println("You have chosen: Rogue.");
                return new StatBlock("rogue", 2, 6, 4, 4);

            case "C":
                //System.out.println("You have chosen: Cleric.");
                return new StatBlock("cleric", 4, 2, 4, 6);

            case "M":
                //System.out.println("You have chosen: Monk.");
                return new StatBlock("monk", 4, 4, 4, 4);

            case "B":
                //System.out.println("You have chosen: Barbarian.");
                return new StatBlock("barbarian", 4, 3, 6, 3);

            case "W":
                //System.out.println("You have chosen: Wizard.");
                return new StatBlock("wizard", 3, 5, 2, 6);


            default:
                //System.out.println("You have chosen: Commoner.");
                return new StatBlock();
        }


    }

    public static Chara createPlayerCharacter() {

        String playerName = App.askUserFor("What is your name? ");

        String profession = App.askUserFor("What is your profession? [F]ighter, [R]ogue, [C]leric, [M]onk, [B]arbarian, or [W]izard? (type in first letter) ");

        StatBlock stats = getStats(profession);

        return new Chara(playerName, 1, stats);
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

        App.askUserFor("\n[Press return to continue]\n");   //Just a pause.

    }

    public void claimLoot(Chara player, Chara opponent) {
        System.out.println("You may claim your opponent's weapon (a " + opponent.getInventory().getWeapon().getDescription() + "), or their armor (a " + opponent.getInventory().getArmor().getDescription() + ").");
        System.out.println("(You have a " + player.getInventory().getWeapon().getDescription() + " and a " + player.getInventory().getArmor().getDescription() + ".)");

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

        App.askUserFor("\n[Press return to continue]\n");   //Just a pause.

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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}

