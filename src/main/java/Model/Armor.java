package Model;

public class Armor extends Equipment {



    public Armor(String Type, String material, int bonus) {
        this.type = Type;
        this.material = material;
        this.bonus = bonus;
        description = "+" + bonus + " " + material + " " + Type;
    }

    public Armor(int level){
        type = Armor.randomArmorType();
        material = Armor.randomMaterial();
        this.bonus = Armor.randomBonus(level);
        description = "+" + bonus + " " + material + " " + type;
    }

    public Armor(){
        type = Armor.randomArmorType();
        material = Armor.randomMaterial();
        bonus = Armor.randomBonus();
        description = "+" + bonus + " " + material + " " + type;
    }


    public static String randomArmorType() {

        final String[] ARMORTYPES = {"shield", "breastplate", "suit", "helmet", "gauntlets", "boots", "cape", "ring", "amulet"};



        return ARMORTYPES[(int)Math.floor(Math.random() * ARMORTYPES.length)];
    }



}
