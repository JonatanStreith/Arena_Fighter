package Model;

import jonst.App;

public class Chara {
    private String name;
    private int level;
    private int health;
    private int attack;
    private int defense;
    private Weapon weapon;
    private Armor armor;


    //constructors

    public Chara(String name, int level, int attack, int defense) {
        this.level = level;
        this.name = name;
        this.health = 50;
        this.attack = attack;
        this.defense = defense;
        weapon = new Weapon(level / 2);
        armor = new Armor(level / 2);
    }

    public Chara() {        //Gets a random opponent

        name = getVillainName();
        health = 50;
        attack = (int) Math.ceil(Math.random() * 5);
        defense = (int) Math.ceil(Math.random() * 5);
        weapon = new Weapon();
        armor = new Armor();
    }

    public Chara(int level) {        //Gets a random LEVELED opponent

        name = getVillainName();
        this.level = level;
        health = 50;
        attack = (int) Math.ceil(Math.random() * level / 2);
        defense = (int) Math.ceil(Math.random() * level / 2);
        weapon = new Weapon(level / 2);
        armor = new Armor(level / 2);

        System.out.print("You face " + name + ", a level " + level + " warrior, in the arena!\n They have an attack of " + attack + " and defense of " + defense + ", ");
        System.out.println("and they have a " + weapon.getDescription() + " and wears " + armor.getDescription() + "!");
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
        int playerAttack = Integer.parseInt((App.askUserFor("Set your attack: ")));
        int playerDefense = Integer.parseInt((App.askUserFor("Set your defense: ")));

        return new Chara(playerName, 1, playerAttack, playerDefense);
    }

    public void levelUp() {
        level++;
    }

    public void reduceHealthBy(int damage) {
        health -= damage;
    }

    public void getLoot(){

        System.out.println("You receive spoils of victory!");

        boolean youGetWeapon = (Math.random() > 0.5) ? true : false;    //Fifty-fifty or so, you get weapon or armor

        if(youGetWeapon){       //If you get a weapon
            Weapon newWeapon = new Weapon();
            String choice = App.askUserFor("You get a " + newWeapon.getDescription() + "! Do you want to use it instead of your current weapon? (y/n) (You have a " + weapon.getDescription() + ".)");

            if(choice.toLowerCase().equals("y")){
                setWeapon(newWeapon);
                System.out.println("You equip your new " + newWeapon.getType() + ".");
            } else{
                System.out.println("You decide to keep your old " + weapon.getType() + ".");
            }


        } else{                 //If you get an armor

            Armor newArmor = new Armor();
            String choice = App.askUserFor("You get a " + newArmor.getDescription() + "! Do you want to use it instead of your current armor? (y/n) (You have a " + armor.getDescription() + ".)");

            if(choice.toLowerCase().equals("y")){
                setArmor(newArmor);
                System.out.println("You equip your new " + newArmor.getType() + ".");
            } else{
                System.out.println("You decide to keep your old " + armor.getType() + ".");
            }

        }


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


    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
}

