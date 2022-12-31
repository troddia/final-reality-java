package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.KNIFE;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.weapon.Abstractweapon;


/**
 * A class that creates Knife.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */

public class Knife extends Abstractweapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name   name of knife
   * @param damage damage, of knife
   * @param weight weight of knife
   */
  public Knife(final String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage, 0, weight, KNIFE);
  }

  @Override
  public boolean usableBlackmageWeapon() {
    return true;
  }


  @Override
  public boolean usableKnightWeapon() {
    return true;
  }


  @Override
  public boolean usableThiefWeapon() {
    return true;
  }
}
