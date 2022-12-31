package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static org.junit.jupiter.api.Assertions.*;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StaffTest {
    Staff staff1;
    Staff staff2;
    Staff staff3;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        staff1 = new Staff("Vara",10,10);
        staff2 = new Staff("Vara Distinta", 8, 1);
        //staff3 is identical to staff1
        staff3 = new Staff("Vara",10,10);
    }


    @Test
    @DisplayName("Equals_ToStringTest")
    void equalsToStringTest() {
        assertTrue(staff1.equals(staff1),"equals of same object");
        assertFalse(staff1.equals(staff2),"equals with diferent objects and atributes, staff1(staff2)");
        assertFalse(staff2.equals(staff1),"equals of same object, staff2(staff1)");
        assertTrue(staff1.equals(staff3), "equals with exactly same atributes, staff1(staff3)");
        assertTrue(staff3.equals(staff1), "equals with exactly same atributes, staff3(staff1)");

        assertEquals("Weapon{name='Vara', damage=0, magicdamage=10, weight=10, type=STAFF}", staff1.toString(), "toString(staff1)");
        assertEquals("Weapon{name='Vara Distinta', damage=0, magicdamage=8, weight=1, type=STAFF}", staff2.toString(), "toString(staff2)");
    }

    @ParameterizedTest
    @DisplayName("Invalid weight input")
    @ValueSource(ints = {0,-1})
    void shouldThrowExceptionWeight(int wstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Staff("error weight",10,wstatval));
    }

    @ParameterizedTest
    @DisplayName("Invalid damage input")
    @ValueSource(ints = {-1,-4})
    void shouldThrowExceptionDamage(int dstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Staff("error damage",dstatval,10));
    }
}