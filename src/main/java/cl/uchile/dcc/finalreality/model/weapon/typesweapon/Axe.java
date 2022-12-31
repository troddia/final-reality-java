package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.AXE;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.weapon.Abstractweapon;


/**
 * A class that creates Axes.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */

public class Axe extends Abstractweapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name    name of axe
   * @param damage  damage, of axe
   * @param weight  weight of axe
   */
  public Axe(final String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage, 0, weight, AXE);
  }

  @Override
  public boolean usableKnightWeapon() {
    return true;
  }

  @Override
  public boolean usableEngineerWeapon() {
    return true;
  }
}