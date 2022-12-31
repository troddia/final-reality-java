package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static org.junit.jupiter.api.Assertions.*;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BowTest {
    Bow bow1;
    Bow bow2;
    Bow bow3;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        bow1 = new Bow("Arco",10,10);
        bow2 = new Bow("Arco Distinta", 8, 1);
        //bow3 is identical to bow1
        bow3 = new Bow("Arco",10,10);
    }

    @Test
    @DisplayName("Equals_ToStringTest")
    void equalsToStringTest() {
        assertTrue(bow1.equals(bow1),"equals of same object");
        assertFalse(bow1.equals(bow2),"equals with diferent objects and atributes, bow1(bow2)");
        assertFalse(bow2.equals(bow1),"equals of same object, bow2(bow1)");
        assertTrue(bow1.equals(bow3), "equals with exactly same atributes, bow1(bow3)");
        assertTrue(bow3.equals(bow1), "equals with exactly same atributes, bow3(bow1)");

        assertEquals("Weapon{name='Arco', damage=10, magicdamage=0, weight=10, type=BOW}", bow1.toString(), "toString(bow1)");
        assertEquals("Weapon{name='Arco Distinta', damage=8, magicdamage=0, weight=1, type=BOW}", bow2.toString(), "toString(bow2)");
    }

    @ParameterizedTest
    @DisplayName("Invalid weight input")
    @ValueSource(ints = {0,-1})
    void shouldThrowExceptionWeight(int wstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Bow("error weight",10,wstatval));
    }

    @ParameterizedTest
    @DisplayName("Invalid damage input")
    @ValueSource(ints = {-1,-4})
    void shouldThrowExceptionDamage(int dstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Bow("error damage",dstatval,10));
    }

}