package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static org.junit.jupiter.api.Assertions.*;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SwordTest {
    Sword sword1;
    Sword sword2;
    Sword sword3;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        sword1 = new Sword("Espada",10,10);
        sword2 = new Sword("Espada Distinta", 8, 1);
        //sword3 is identical to sword1
        sword3 = new Sword("Espada",10,10);
    }


    @Test
    @DisplayName("Equals_ToStringTest")
    void equalsToStringTest() {
        assertTrue(sword1.equals(sword1),"equals of same object");
        assertFalse(sword1.equals(sword2),"equals with diferent objects and atributes, sword1(sword2)");
        assertFalse(sword2.equals(sword1),"equals of same object, sword2(sword1)");
        assertTrue(sword1.equals(sword3), "equals with exactly same atributes, sword1(sword3)");
        assertTrue(sword3.equals(sword1), "equals with exactly same atributes, sword3(sword1)");

        assertEquals("Weapon{name='Espada', damage=10, magicdamage=0, weight=10, type=SWORD}", sword1.toString(), "toString(sword1)");
        assertEquals("Weapon{name='Espada Distinta', damage=8, magicdamage=0, weight=1, type=SWORD}", sword2.toString(), "toString(sword2)");
    }

    @ParameterizedTest
    @DisplayName("Invalid weight input")
    @ValueSource(ints = {0,-1})
    void shouldThrowExceptionWeight(int wstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Sword("error weight",10,wstatval));
    }

    @ParameterizedTest
    @DisplayName("Invalid damage input")
    @ValueSource(ints = {-1,-4})
    void shouldThrowExceptionDamage(int dstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Sword("error damage",dstatval,10));
    }
}