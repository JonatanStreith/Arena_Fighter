package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class WeaponTest {


    @Test
    public void NewWeaponSpecificTest() {

        String type = "glaive";
        String material = "dinosaur bone";
        int bonus = 11;

        Weapon glaive = new Weapon(type, material, bonus);


        //By testing that the description is exactly right, we also test that the other data are added correctly. Efficient!
        assertNotNull(glaive);
        assertEquals("+11 dinosaur bone glaive", glaive.getDescription());

    }

    @Test
    public void NewWeaponByLevelTest() {




        Weapon randomLvl0Weapon = new Weapon(0);
        Weapon randomLvl10Weapon = new Weapon(10);



        //Assert that new weapon exists, has a description, and a bonus somewhere between zero and specified level.
        assertNotNull(randomLvl0Weapon);
        assertNotNull(randomLvl10Weapon);

        assertNotNull(randomLvl0Weapon.getDescription());
        assertNotNull(randomLvl10Weapon.getDescription());

        assertTrue(randomLvl0Weapon.getBonus()>=0 && randomLvl0Weapon.getBonus() <= 0);
        assertTrue(randomLvl10Weapon.getBonus()>=0 && randomLvl10Weapon.getBonus() <= 10);


    }

    @Test
    public void NewWeaponTest() {

        Weapon newWeapon = new Weapon();


        assertNotNull(newWeapon);


        assertNotNull(newWeapon.getDescription());

        //Assert that new weapon exists, has a description, and a bonus somewhere between zero and five.
        assertTrue(newWeapon.getBonus()>=0 && newWeapon.getBonus() <= 5);


    }

    @Test
    public void randomWeaponTypeTest() {

        String testReturn = Weapon.randomWeaponType();
        assertNotEquals("", testReturn);


    }


    @Test
    public void randomWeaponMaterialTest() {

        String testReturn = Weapon.randomMaterial();
        assertNotEquals("", testReturn);

    }
    @Test
    public void randomWeaponBonusTest() {

        int testReturn = Weapon.randomBonus();

        assertTrue(testReturn >= 0 && testReturn <= 5);

    }
    @Test
    public void randomWeaponBonusByLevelTest() {

        int testReturn = Weapon.randomBonus(10);

        assertTrue(testReturn >= 0 && testReturn <= 10);
    }


}
