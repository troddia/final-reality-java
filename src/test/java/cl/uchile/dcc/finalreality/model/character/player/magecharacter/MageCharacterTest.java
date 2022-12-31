package cl.uchile.dcc.finalreality.model.character.player.magecharacter;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MageCharacterTest {
    Mage b1;
    Mage b2;
    Mage b3;
    Mage w1;
    Mage w2;
    Mage w3;

    Weapon staffb;
    Weapon staffw;

    Enemy enemy;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();

        b1 = new BlackMage("BlackMage", 10, 10, 10, q);
        b2 = new BlackMage("BlackMage", 10, 10, 10, q);
        b3 = new BlackMage("not", 10, 10, 10, q);

        w1 = new WhiteMage("WhiteMage", 10, 10,10, q);
        w2 = new WhiteMage("WhiteMage", 10, 10, 10, q);
        w3 = new WhiteMage("not", 10, 10,10, q);

        staffb = new Staff("black wand",10,10);
        staffw = new Staff("white wand", 10, 10);

        enemy = new Enemy("enemy", 10, 10, 10, 10, q);
    }

    @Test
    @DisplayName("Equals and toString Test")
    void equalsAndToStringMagePlayerTest() {
        assertTrue(b1.equals(b1));

        assertTrue(b1.equals(b2));
        assertTrue(b2.equals(b1));

        assertFalse(b2.equals(b3));
        assertFalse(b3.equals(b2));

        assertFalse(b1.equals(enemy));
        assertFalse(enemy.equals(b1));

        assertFalse(b1.equals(staffw));
        assertFalse(staffw.equals(b1));
        // revisar ese espacio raro...
        assertEquals("BlackMage{ maxMp=10, maxHp=10, defense=10, name='BlackMage'}",b1.toString());
        assertEquals("BlackMage{ maxMp=10, maxHp=10, defense=10, name='not'}", b3.toString());

        assertTrue(w1.equals(w1));

        assertTrue(w1.equals(w2));
        assertTrue(w2.equals(w1));

        assertFalse(w2.equals(w3));
        assertFalse(w3.equals(w2));

        assertFalse(w1.equals(enemy));
        assertFalse(enemy.equals(w1));

        assertFalse(w1.equals(staffb));
        assertFalse(staffb.equals(w1));

        assertEquals("WhiteMage{maxMp=10, maxHp=10, defense=10, name='WhiteMage'}",w1.toString());
        assertEquals("WhiteMage{maxMp=10, maxHp=10, defense=10, name='not'}", w3.toString());
    }

    @Test
    @DisplayName("getName() Test")
    void getNameTest() {
        assertEquals("BlackMage", b1.getName());
        assertEquals("WhiteMage", w1.getName());
    }

    @Test
    @DisplayName("getDefence()")
    void getDefenceTest() {
        assertEquals(10, b1.getDefense());
        assertEquals(10, w1.getDefense());
    }

    @Test
    @DisplayName("EquipWeapon() test")
    void equipWeaponTest() {
        b1.equip(staffb);
        w1.equip(staffw);
        assertEquals("Weapon{name='black wand', damage=0, magicdamage=10, weight=10, type=STAFF}", b1.getEquippedWeapon().toString());
        assertEquals("Weapon{name='white wand', damage=0, magicdamage=10, weight=10, type=STAFF}", w1.getEquippedWeapon().toString());
    }

    @Test
    @DisplayName("Mage Hp Test")
    void mageHpTest() throws InvalidStatValueException {
        assertEquals(10, b1.getMaxHp());
        b1.setCurrentHp(5);
        assertEquals(5, b1.getCurrentHp());
        b1.setCurrentHp(10);

        assertEquals(10, w1.getMaxHp());
        w1.setCurrentHp(5);
        assertEquals(5, w1.getCurrentHp());
        w1.setCurrentHp(10);
    }

    @Test
    @DisplayName("Mage Mp Test")
    void mageMpTest() throws InvalidStatValueException {
        assertEquals(10, b1.getMaxMp());
        b1.setCurrentMp(5);
        assertEquals(5, b1.getCurrentMp());
        b1.setCurrentMp(10);

        assertEquals(10, w1.getMaxMp());
        w1.setCurrentMp(5);
        assertEquals(5, w1.getCurrentMp());
        w1.setCurrentMp(10);
    }

    @ParameterizedTest
    @DisplayName("Mp constructor exceptions")
    @ValueSource(ints = {-1, -2})
    void MpConstructorexceptions(int Mp) {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        assertThrows(InvalidStatValueException.class,
                () -> new BlackMage("error weight",10,10, Mp, q));
    }

    @ParameterizedTest
    @DisplayName("Mp set() exceptions")
    @ValueSource(ints = {-1, -2})
    void SetMpexceptions(int Mp) {
        assertThrows(InvalidStatValueException.class,
                () ->  b1.setCurrentMp(Mp));
    }

    @Test
    @DisplayName("Mp set() exceptions management")
    void mpSetExceptionsManagement() throws InvalidStatValueException {
        b1.setCurrentMp(20);
        assertEquals(10, b1.getCurrentMp());

        b1.setCurrentMp(11);
        assertEquals(10, b1.getCurrentMp());
    }
}