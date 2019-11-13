package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArmorTest {


    @Test
    public void NewArmorSpecificTest() {

        String type = "barding";
        String material = "plastic";
        int bonus = 13;

        Armor barding = new Armor(type, material, bonus);


        //By testing that the description is exactly right, we also test that the other data are added correctly. Efficient!
        assertNotNull(barding);
        assertEquals("+13 plastic barding", barding.getDescription());

    }

    @Test
    public void NewArmorByLevelTest() {




        Armor randomLvl0Armor = new Armor(0);
        Armor randomLvl10Armor = new Armor(10);



        //Assert that new Armor exists, has a description, and a bonus somewhere between zero and specified level.
        assertNotNull(randomLvl0Armor);
        assertNotNull(randomLvl10Armor);

        assertNotNull(randomLvl0Armor.getDescription());
        assertNotNull(randomLvl10Armor.getDescription());

        assertTrue(randomLvl0Armor.getBonus()>=0 && randomLvl0Armor.getBonus() <= 0);
        assertTrue(randomLvl10Armor.getBonus()>=0 && randomLvl10Armor.getBonus() <= 10);


    }

    @Test
    public void NewArmorTest() {

        Armor newArmor = new Armor();


        assertNotNull(newArmor);


        assertNotNull(newArmor.getDescription());

        //Assert that new Armor exists, has a description, and a bonus somewhere between zero and five.
        assertTrue(newArmor.getBonus()>=0 && newArmor.getBonus() <= 5);


    }

    @Test
    public void randomArmorTypeTest() {

        String testReturn = Armor.randomArmorType();
        assertNotEquals("", testReturn);


    }


    @Test
    public void randomArmorMaterialTest() {

        String testReturn = Armor.randomMaterial();
        assertNotEquals("", testReturn);

    }
    @Test
    public void randomArmorBonusTest() {

        int testReturn = Armor.randomBonus();

        assertTrue(testReturn >= 0 && testReturn <= 5);

    }
    @Test
    public void randomArmorBonusByLevelTest() {

        int testReturn = Armor.randomBonus(10);

        assertTrue(testReturn >= 0 && testReturn <= 10);
    }


}
