package Model;

public class StatBlock {

    private String profession;

    private int strength;
    private int dexterity;
    private int constitution;
    private int wisdom;


    public StatBlock(String profession, int strength, int dexterity, int constitution, int wisdom) {
        this.profession = profession;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.wisdom = wisdom;
    }

    public StatBlock(int level) {
        strength = (int) Math.ceil(Math.random() * level / 2);
        dexterity = (int) Math.ceil(Math.random() * level / 2);
        constitution = (int) Math.ceil(Math.random() * level / 2);
        wisdom = (int) Math.ceil(Math.random() * level / 2);

    }

    public StatBlock() {
        profession= "commoner";
        strength = (int) Math.ceil(Math.random() * 5);
        dexterity = (int) Math.ceil(Math.random() * 5);
        constitution = (int) Math.ceil(Math.random() * 5);
        wisdom = (int) Math.ceil(Math.random() * 5);

    }


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }


    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
