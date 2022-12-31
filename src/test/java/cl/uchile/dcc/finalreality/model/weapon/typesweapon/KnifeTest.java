package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static org.junit.jupiter.api.Assertions.*;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class KnifeTest {
    Knife knife1;
    Knife knife2;
    Knife knife3;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        knife1 = new Knife("Cuchillo",10,10);
        knife2 = new Knife("Cuchillo Distinta", 8, 1);
        //knife3 is identical to knife1
        knife3 = new Knife("Cuchillo",10,10);
    }


    @Test
    @DisplayName("Equals_ToStringTest")
    void equalsToStringTest() {
        assertTrue(knife1.equals(knife1),"equals of same object");
        assertFalse(knife1.equals(knife2),"equals with diferent objects and atributes, knife1(knife2)");
        assertFalse(knife2.equals(knife1),"equals of same object, knife2(knife1)");
        assertTrue(knife1.equals(knife3), "equals with exactly same atributes, knife1(knife3)");
        assertTrue(knife3.equals(knife1), "equals with exactly same atributes, knife3(knife1)");

        assertEquals("Weapon{name='Cuchillo', damage=10, magicdamage=0, weight=10, type=KNIFE}", knife1.toString(), "toString(knife1)");
        assertEquals("Weapon{name='Cuchillo Distinta', damage=8, magicdamage=0, weight=1, type=KNIFE}", knife2.toString(), "toString(knife2)");
    }

    @ParameterizedTest
    @DisplayName("Invalid weight input")
    @ValueSource(ints = {0,-1})
    void shouldThrowExceptionWeight(int wstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Knife("error weight",10,wstatval));
    }

    @ParameterizedTest
    @DisplayName("Invalid damage input")
    @ValueSource(ints = {-1,-4})
    void shouldThrowExceptionDamage(int dstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Knife("error damage",dstatval,10));
    }
}