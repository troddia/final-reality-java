package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;



class NormalCharacterTest {
    PlayerCharacter  e1;
    PlayerCharacter e2;
    PlayerCharacter e3;
    PlayerCharacter k1;
    PlayerCharacter k2;
    PlayerCharacter k3;
    PlayerCharacter t1;
    PlayerCharacter t2;
    PlayerCharacter t3;

    Weapon axe;

    Weapon bow;
    Weapon sword;

    Enemy enemy;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();

        e1 = new Engineer("Engineer", 10, 10, q);
        e2 = new Engineer("Engineer", 10, 10, q);
        e3 = new Engineer("not", 10, 10, q);

        k1 = new Knight("Knight", 10, 10, q);
        k2 = new Knight("Knight", 10, 10, q);
        k3 = new Knight("not", 10, 10, q);

        t1 = new Thief("Thief", 10, 10, q);
        t2 = new Thief("Thief", 10, 10, q);
        t3 = new Thief("not", 10, 2, q);

        axe = new Axe("arma",10,10);
        bow = new Bow("arma", 10, 10);
        sword = new Sword("arma", 10, 10);

        enemy = new Enemy("enemy", 10, 10, 10, 10, q);
    }

    @Test
    @DisplayName("Equals and toString Test")
    void equalsAndToStringNormalPlayerTest() {
        assertTrue(e1.equals(e1));

        assertTrue(e1.equals(e2));
        assertTrue(e2.equals(e1));

        assertFalse(e2.equals(e3));
        assertFalse(e3.equals(e2));

        assertFalse(e1.equals(enemy));
        assertFalse(enemy.equals(e1));

        assertFalse(e1.equals(sword));
        assertFalse(sword.equals(e1));

        assertEquals("Engineer{maxHp=10, defense=10, name='Engineer'}",e1.toString());
        assertEquals("Engineer{maxHp=10, defense=10, name='not'}", e3.toString());

        assertTrue(k1.equals(k1));

        assertTrue(k1.equals(k2));
        assertTrue(k2.equals(k1));

        assertFalse(k2.equals(k3));
        assertFalse(k3.equals(k2));

        assertFalse(k1.equals(enemy));
        assertFalse(enemy.equals(k1));

        assertFalse(k1.equals(sword));
        assertFalse(sword.equals(k1));

        assertEquals("Knight{maxHp=10, defense=10, name='Knight'}",k1.toString());
        assertEquals("Knight{maxHp=10, defense=10, name='not'}", k3.toString());

        assertTrue(t1.equals(t1));

        assertTrue(t1.equals(t2));
        assertTrue(t2.equals(t1));

        assertFalse(t2.equals(t3));
        assertFalse(t3.equals(t2));

        assertFalse(t1.equals(enemy));
        assertFalse(enemy.equals(t1));

        assertFalse(t1.equals(sword));
        assertFalse(sword.equals(t1));

        assertEquals("Thief{maxHp=10, defense=10, name='Thief'}",t1.toString());
        assertEquals("Thief{maxHp=10, defense=2, name='not'}", t3.toString());
    }

    @Test
    @DisplayName("getName() Test")
    void getNameTest() {
        assertEquals("Engineer", e1.getName());
        assertEquals("Knight", k1.getName());
        assertEquals("Thief", t1.getName());
    }

    @Test
    @DisplayName("getDefence()")
    void getDefenceTest() {
        assertEquals(10, e1.getDefense());
        assertEquals(10, k1.getDefense());
        assertEquals(10, t1.getDefense());
    }

    @Test
    @DisplayName("EquipWeapon() and getEquippedWeapon().toString test")
    void equipWeaponTest() {
        e1.equip(axe);
        k1.equip(sword);
        t1.equip(bow);
        assertEquals("Weapon{name='arma', damage=10, magicdamage=0, weight=10, type=AXE}", e1.getEquippedWeapon().toString());
        assertEquals("Weapon{name='arma', damage=10, magicdamage=0, weight=10, type=SWORD}", k1.getEquippedWeapon().toString());
        assertEquals("Weapon{name='arma', damage=10, magicdamage=0, weight=10, type=BOW}", t1.getEquippedWeapon().toString());
    }

    @Test
    @DisplayName("Hp Normal Character Test")
    void hpNormalCharTest() throws InvalidStatValueException {
        assertEquals(10, e1.getMaxHp());
        e1.setCurrentHp(5);
        assertEquals(5, e1.getCurrentHp());
        e1.setCurrentHp(10);

        assertEquals(10, k1.getMaxHp());
        k1.setCurrentHp(5);
        assertEquals(5, k1.getCurrentHp());
        k1.setCurrentHp(10);

        assertEquals(10, t1.getMaxHp());
        t1.setCurrentHp(5);
        assertEquals(5, t1.getCurrentHp());
        t1.setCurrentHp(10);
    }
}
