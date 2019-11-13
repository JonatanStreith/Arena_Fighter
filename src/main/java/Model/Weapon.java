package Model;

public class Weapon extends Equipment {



    public Weapon(String type, String material, int bonus) {
        this.type = type;
        this.material = material;
        this.bonus = bonus;
        description = "+" + bonus + " " + material + " " + type;
    }

    public Weapon(int level){
        type = Weapon.randomWeaponType();
        material = Weapon.randomMaterial();
        this.bonus = Weapon.randomBonus(level);
        description = "+" + bonus + " " + material + " " + type;
    }


    public Weapon(){
        type = Weapon.randomWeaponType();
        material = Weapon.randomMaterial();
        bonus = Weapon.randomBonus();
        description = "+" + bonus + " " + material + " " + type;
    }


    public static String randomWeaponType() {

        final String[] weaponTypes = {"axe", "sword", "spear", "bow", "hammer", "dagger", "blunderbuss", "mace", "staff"};

        return weaponTypes[(int)Math.floor(Math.random() * weaponTypes.length)];
    }





}
