package Model;

public class Equipment {
    protected String description;
    protected String material;
    protected int bonus;
    protected  String type;



    public static String randomMaterial() {

        final String[] MATERIALS = {"iron", "wooden", "steel", "bronze", "leather", "cloth", "crystal", "mithril", "force"};

        String material = MATERIALS[(int)Math.floor(Math.random() * MATERIALS.length)];

        return material;
    }

    public static int randomBonus(int level){

        return (int)Math.ceil(Math.random() * level/2);   //Returns a number between 1 and 5

    }

    public static int randomBonus(){

        return (int)Math.ceil(Math.random() * 5);   //Returns a number between 1 and 5

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

