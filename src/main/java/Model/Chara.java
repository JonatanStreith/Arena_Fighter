package Model;

public class Chara {
    private String name;
    private int health;
    private int attack;
    private int defense;

    public Chara(String name, int attack, int defense) {
        this.name = name;
        this.health = 50;
        this.attack = attack;
        this.defense = defense;
    }

    public Chara() {        //Gets a random opponent

        name = getVillainName();       //Later make function to get random name from list
        health = 50;
        attack = (int)Math.ceil(Math.random() * 5);
        defense = (int)Math.ceil(Math.random() * 5);
    }

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

    public void reduceHealthBy(int damage){
        health -= damage;
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

    public static String getVillainName(){

        String[] names = {
                "Grognak the Barbarian",
                "Blackthorne",
                "Silktongs of the Fell Order",
                "Donut Steel",
                "Five ducks in a man costume"
        };


        return names[(int)Math.floor(Math.random() * names.length)];


    }
}

