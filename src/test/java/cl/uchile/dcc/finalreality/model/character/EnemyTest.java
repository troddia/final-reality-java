package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    GameCharacter mage;
    Weapon weapon;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        enemy1 = new Enemy("Enemy", 10, 10, 10, 10, q);
        enemy2 = new Enemy("Enemy", 10, 10, 10, 10, q);
        enemy3 = new Enemy("Not Enemy", 9, 10, 9, 10, q);
        mage = new WhiteMage("mage", 10, 10, 10, q);
        weapon = new Axe("weapon", 10, 10);

    }

    @Test
    @DisplayName("Checkea funcion getWeight()")
    void getWeight() {
        assertEquals(10, enemy1.getWeight());
        assertNotEquals(10, enemy3.getWeight());
    }

    @Test
    @DisplayName("getDefence() Test")
    void getDefenceTest() {
        assertEquals(10, enemy1.getDefense());
        assertNotEquals(10, enemy3.getDefense());

    }

    @Test
    @DisplayName("getName() Test")
    void getNameTest() {
        assertEquals("Enemy",enemy1.getName());
        assertEquals("Not Enemy", enemy3.getName());
    }

    @Test
    @DisplayName("EnemyHpTest")
    void enemyHpTest() throws InvalidStatValueException {
        assertEquals(10, enemy1.getMaxHp());
        enemy1.setCurrentHp(5);
        assertEquals(5, enemy1.getCurrentHp());
        enemy1.setCurrentHp(10);

    }

    @Test
    @DisplayName("Enemy Equals Test")
    void enemyEqualsTest() {


        assertTrue(enemy1.equals(enemy2));
        assertTrue(enemy2.equals(enemy1));

        assertFalse(enemy2.equals(enemy3));
        assertFalse(enemy3.equals(enemy2));

        assertTrue(enemy1.equals(enemy1));

        assertFalse(enemy1.equals(mage));
        assertFalse(mage.equals(enemy1));

        assertFalse(enemy1.equals(weapon));
        assertFalse(weapon.equals(enemy1));
    }

    @Test
    void testToString() {
        assertEquals("Enemy{maxHp=10, defense=10, weight=10, name='Enemy'}",enemy1.toString());
        assertEquals("Enemy{maxHp=10, defense=9, weight=9, name='Not Enemy'}", enemy3.toString());
    }

    @ParameterizedTest
    @DisplayName("weight enemy exception")
    @ValueSource(ints = {0, -1})
    void weightEnemyException(int weightval) {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        assertThrows(InvalidStatValueException.class,
                () -> new Enemy("error weight",weightval,10, 10,  10, q));
    }


}