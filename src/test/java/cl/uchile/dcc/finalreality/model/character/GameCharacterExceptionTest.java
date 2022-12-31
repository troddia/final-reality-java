package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameCharacterExceptionTest {
    GameCharacter enemy;
    GameCharacter engineer;
    GameCharacter whitemage;


    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        enemy = new Enemy("enemy", 10, 10, 10, 10, q);
        engineer = new Engineer("engineer", 10, 10,q);
        whitemage = new WhiteMage("whitemage", 10, 10, 10, q);
    }

    @ParameterizedTest
    @DisplayName("defence character exception")
    @ValueSource(ints = {-1, -2})
    void defenceEnemyException(int def) {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        assertThrows(InvalidStatValueException.class,
                () -> new Enemy("error defence",10,10, def, 10, q));

        assertThrows(InvalidStatValueException.class,
                () -> new Engineer("error defence",10,def,q));

        assertThrows(InvalidStatValueException.class,
                () -> new BlackMage("error defence",10, def,10,q));
    }

    @ParameterizedTest
    @DisplayName("Hp constructor test")
    @ValueSource(ints = { 0, -1})
    void hpConstructorTest(int cHp) {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        assertThrows(InvalidStatValueException.class,
                () -> new WhiteMage("whitemage", cHp, 10, 10, q));

        assertThrows(InvalidStatValueException.class,
                () -> new Engineer("engineer", cHp, 10,q));

        assertThrows(InvalidStatValueException.class,
                () -> new Enemy("enemy", 10, cHp, 10, 10, q));

    }

    @ParameterizedTest
    @DisplayName("Hp set function exception test")
    @ValueSource(ints = {-1, -2})
    void hpSetFunctionTest(int Hp) {
        assertThrows(InvalidStatValueException.class,
                () ->  whitemage.setCurrentHp(Hp));
        assertThrows(InvalidStatValueException.class,
                () ->  engineer.setCurrentHp(Hp));
        assertThrows(InvalidStatValueException.class,
                () ->  enemy.setCurrentHp(Hp));
    }

    @Test
    @DisplayName("Exception Hp catch when value is higher than maxHp")
    void exceptionSetHpcatch() throws InvalidStatValueException {
        whitemage.setCurrentHp(100);
        assertEquals(10, whitemage.getCurrentHp());

        engineer.setCurrentHp(50);
        assertEquals(10, engineer.getCurrentHp());

        enemy.setCurrentHp(60);
        assertEquals(10, enemy.getCurrentHp());
    }
}
