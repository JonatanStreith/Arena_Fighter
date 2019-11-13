package Model;

public class Equipment {
    protected String description;
    protected String material;
    protected int bonus;
    protected  String type;



    public static String randomMaterial() {

        final String[] materials = {"iron", "wooden", "steel", "bronze", "leather", "cloth", "crystal", "mithril", "force"};

        String material = materials[(int)Math.floor(Math.random() * materials.length)];

        return material;
    }

    public static int randomBonus(int level){

        return (int)Math.ceil(Math.random() * level);   //Returns a number between 0 and half the level. If level is below 2, number will always be zero. Otherwise, zero is very rare. This is appropriate.

    }

    public static int randomBonus(){

        return (int)Math.ceil(Math.random() * 5);   //Returns a number between 0 and 5

    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getMaterial() {
        return material;
    }

    public int getBonus() {
        return bonus;
    }
}

