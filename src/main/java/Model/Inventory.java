package Model;

public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory(Weapon weapon, Armor armor) {
        this.weapon = weapon;
        this.armor = armor;
    }

    public Inventory(int level) {
        weapon = new Weapon(level / 2);
        armor = new Armor(level / 2);
    }

    public Inventory() {
        weapon = new Weapon();
        armor = new Armor();
    }



    //Getters setters
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
