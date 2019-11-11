package Model;

public class Weapon extends Equipment {

    private String weaponType;

    public Weapon(String weaponType, String material, int bonus) {
        this.weaponType = weaponType;
        this.material = material;
        this.bonus = bonus;
        description = "+" + bonus + " " + material + " " + weaponType;
    }

    public Weapon(int bonus){
        weaponType = Weapon.randomWeaponType();
        material = Weapon.randomMaterial();
        this.bonus = bonus;
        description = "+" + bonus + " " + material + " " + weaponType;
    }


    public Weapon(){
        weaponType = Weapon.randomWeaponType();
        material = Weapon.randomMaterial();
        bonus = Weapon.randomBonus();
        description = "+" + bonus + " " + material + " " + weaponType;
    }


    public static String randomWeaponType() {

        final String[] WEAPONTYPES = {"axe", "sword", "spear", "bow", "hammer", "dagger", "blunderbuss", "mace", "staff"};

        String type = WEAPONTYPES[(int)Math.floor(Math.random() * WEAPONTYPES.length)];

        return type;
    }

    public String getWeaponType() {
        return weaponType;
    }



}
