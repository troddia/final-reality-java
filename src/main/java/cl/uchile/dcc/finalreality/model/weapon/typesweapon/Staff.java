package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.STAFF;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.weapon.Abstractweapon;

/**
 * A class that creates Staff.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */

public class Staff extends Abstractweapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name  name of staff
   * @param damage damage, of staff
   * @param weight  weight of staff
   */
  public Staff(final String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, 0, damage, weight, STAFF);
  }

  @Override
  public boolean usableBlackmageWeapon() {
    return true;
  }

  @Override
  public boolean usableWhitemageWeapon() {
    return true;
  }

}