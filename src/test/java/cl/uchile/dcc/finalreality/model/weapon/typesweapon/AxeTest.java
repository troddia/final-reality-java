package cl.uchile.dcc.finalreality.model.weapon.typesweapon;


import static org.junit.jupiter.api.Assertions.*;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class AxeTest {
    Axe axe1;
    Axe axe2;
    Axe axe3;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
      axe1 = new Axe("Hacha",10,10);
      axe2 = new Axe("Hacha Distinta", 8, 1);
      //axe3 is identical to axe 1
      axe3 = new Axe("Hacha",10,10);
    }


    @Test
    @DisplayName("Equals_ToStringTest")
    void equalsToStringTest() {
      assertTrue(axe1.equals(axe1),"equals of same object");
      assertFalse(axe1.equals(axe2),"equals with diferent objects and atributes, axe1(axe2)");
      assertFalse(axe2.equals(axe1),"equals of same object, axe2(axe1)");
      assertTrue(axe1.equals(axe3), "equals with exactly same atributes, axe1(axe3)");
      assertTrue(axe3.equals(axe1), "equals with exactly same atributes, axe3(axe1)");

      assertEquals("Weapon{name='Hacha', damage=10, magicdamage=0, weight=10, type=AXE}", axe1.toString(), "toString(axe1)");
      assertEquals("Weapon{name='Hacha Distinta', damage=8, magicdamage=0, weight=1, type=AXE}", axe2.toString(), "toString(axe1)");
    }

    @ParameterizedTest
    @DisplayName("Invalid weight input")
    @ValueSource(ints = {0,-1})
    void shouldThrowExceptionWeight(int wstatval) {
      assertThrows(InvalidStatValueException.class,
              () -> new Axe("error weight",10,wstatval));
    }

    @ParameterizedTest
    @DisplayName("Invalid damage input")
    @ValueSource(ints = {-1,-4})
    void shouldThrowExceptionDamage(int dstatval) {
        assertThrows(InvalidStatValueException.class,
                () -> new Axe("error damage",dstatval,10));
    }
}