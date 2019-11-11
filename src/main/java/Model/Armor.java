package Model;

public class Armor extends Equipment {

    private String armorType;

    public Armor(String armorType, String material, int bonus) {
        this.armorType = armorType;
        this.material = material;
        this.bonus = bonus;
        description = "+" + bonus + " " + material + " " + armorType;
    }

    public Armor(int bonus){
        armorType = Armor.randomArmorType();
        material = Armor.randomMaterial();
        this.bonus = bonus;
        description = "+" + bonus + " " + material + " " + armorType;
    }

    public Armor(){
        armorType = Armor.randomArmorType();
        material = Armor.randomMaterial();
        bonus = Armor.randomBonus();
        description = "+" + bonus + " " + material + " " + armorType;
    }


    public static String randomArmorType() {

        final String[] ARMORTYPES = {"shield", "breastplate", "suit", "helmet", "gauntlets", "boots", "cape", "ring", "amulet"};

        String type = ARMORTYPES[(int)Math.floor(Math.random() * ARMORTYPES.length)];

        return type;
    }

    public String getArmorType() {
        return armorType;
    }



}
