package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.BOW;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.weapon.Abstractweapon;

/**
 * A class that creates Bows.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */

public class Bow extends Abstractweapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name   name of bow
   * @param damage damage, of bow
   * @param weight weight of bow
   */
  public Bow(final String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage, 0, weight, BOW);
  }

  @Override
  public boolean usableEngineerWeapon() {
    return true;
  }

  @Override
  public boolean usableThiefWeapon() {
    return true;
  }
}
