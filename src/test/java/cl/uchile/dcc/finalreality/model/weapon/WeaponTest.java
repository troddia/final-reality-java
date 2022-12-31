package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.*;
import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    Weapon axe;
    Weapon axe2;
    Weapon axe3;
    Weapon bow;
    Weapon knife;
    Weapon staff;
    Weapon sword;
    Weapon swordF;
    Weapon axeF;
    Weapon knifeF;
    Weapon bowF;
    Weapon staffF;
    Engineer engineer;




    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();

        axe = new Axe("arma",10,10);
        bow = new Bow("arma", 10, 10);
        knife = new Knife("arma", 10, 10);
        staff = new Staff("arma", 10, 10);
        sword = new Sword("arma", 10, 10);
        axe2 = new Axe("arma",10,10);
        axe3 = new Axe("arma",1,1);

        swordF = new Sword("Espada",1,1);
        staffF = new Staff("Vara",2,2);
        knifeF = new Knife("Cuchillo",3,3);
        bowF = new Bow("Arco",4,4);
        axeF = new Axe("Hacha",5,5);

        engineer = new Engineer("Engineer", 10, 10, q);
    }

    @Test
    @DisplayName("same Atributes different Type Class Test, equals()")
    void diffWeaponsEqualsTest() {
        assertFalse(axe.equals(bow));
        assertFalse(bow.equals(axe));

        assertFalse(knife.equals(sword));
        assertFalse(sword.equals(knife));

        assertFalse(staff.equals(bow));
        assertFalse(bow.equals(staff));

        assertTrue(axe.equals(axe2));
        assertTrue(axe2.equals(axe));

        assertFalse(axe.equals(axe3));
        assertFalse(axe3.equals(axe));

        assertFalse(axe.equals(engineer), "Case when comparing to non weapon object.");
        assertFalse(engineer.equals(axe));
    }

    @Test
    @DisplayName("getName() Test")
    void getNameTest() {
        assertEquals("Espada", swordF.getName(), "GetName");
        assertEquals("Vara", staffF.getName(), "GetName");
        assertEquals("Cuchillo", knifeF.getName(), "GetName");
        assertEquals("Arco", bowF.getName(), "GetName");
        assertEquals("Hacha", axeF.getName(), "GetName");

    }

    @Test
    @DisplayName("getDamage() Test")
    void getDamageTest() {
        assertEquals(1, swordF.getDamage(),"Checks damage of swordF ");
        assertEquals(0, staffF.getDamage(),"Checks damage of staffF ");
        assertEquals(3, knifeF.getDamage(),"Checks damage of knifeF ");
        assertEquals(4, bowF.getDamage(),"Checks damage of bowF ");
        assertEquals(5, axeF.getDamage(),"Checks damage of axeF ");
    }

    @Test
    @DisplayName("get MagicDamageTest")
    void getMagicDamageTest() {
        assertEquals(0, swordF.getMagicDamage(),"Checks magicdamage of swordF ");
        assertEquals(2, staffF.getMagicDamage(),"Checks magicdamage of staffF ");
        assertEquals(0, knifeF.getMagicDamage(),"Checks magicdamage of knifeF ");
        assertEquals(0, bowF.getMagicDamage(),"Checks magicdamage of bowF ");
        assertEquals(0, axeF.getMagicDamage(),"Checks magicdamage of axeF ");
    }

    @Test
    @DisplayName("getWeight() Test")
    void getWeightTest() {
        assertEquals(1, swordF.getWeight(),"Checks the weight of sword1");
        assertEquals(2, staffF.getWeight(),"Checks the weight of staffF");
        assertEquals(3, knifeF.getWeight(),"Checks the weight of knifeF");
        assertEquals(4, bowF.getWeight(),"Checks the weight of bowF");
        assertEquals(5, axeF.getWeight(),"Checks the weight of axeF");
    }

    @Test
    @DisplayName("getType() Weapon Test")
    void getTypeWeaponTest() {
        assertEquals(AXE, axe.getType());
        assertEquals(BOW, bow.getType());
        assertEquals(KNIFE, knife.getType());
        assertEquals(STAFF, staff.getType());
        assertEquals(SWORD, sword.getType());
    }

    @Test
    @DisplayName("Usable By Knight")
    void usableByKnight() {
        assertTrue(sword.usableKnightWeapon());
        assertTrue(axe.usableKnightWeapon());
        assertTrue(knife.usableKnightWeapon());

        assertFalse(bow.usableKnightWeapon());
        assertFalse(staff.usableKnightWeapon());
    }

    @Test
    @DisplayName("Usable By engineer")
    void usableByEngineer() {
        assertTrue(bow.usableEngineerWeapon());
        assertTrue(axe.usableEngineerWeapon());


        assertFalse(knife.usableEngineerWeapon());
        assertFalse(sword.usableEngineerWeapon());
        assertFalse(staff.usableEngineerWeapon());
    }

    @Test
    @DisplayName("Usable By thief")
    void usableByThief() {
        assertTrue(sword.usableThiefWeapon());
        assertTrue(knife.usableThiefWeapon());
        assertTrue(bow.usableThiefWeapon());



        assertFalse(axe.usableThiefWeapon());
        assertFalse(staff.usableThiefWeapon());
    }

    @Test
    @DisplayName("Usable By blackmage")
    void usableByBlackmage() {
        assertTrue(knife.usableBlackmageWeapon());
        assertTrue(staff.usableBlackmageWeapon());



        assertFalse(bow.usableBlackmageWeapon());
        assertFalse(axe.usableBlackmageWeapon());
        assertFalse(sword.usableBlackmageWeapon());
    }

    @Test
    @DisplayName("Usable By whitemage")
    void usableByWhitemage() {
        assertTrue(staff.usableWhitemageWeapon());



        assertFalse(knife.usableWhitemageWeapon());
        assertFalse(bow.usableWhitemageWeapon());
        assertFalse(axe.usableWhitemageWeapon());
        assertFalse(sword.usableWhitemageWeapon());
    }

}