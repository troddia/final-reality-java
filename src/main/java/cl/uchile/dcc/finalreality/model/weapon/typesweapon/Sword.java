package cl.uchile.dcc.finalreality.model.weapon.typesweapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.SWORD;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.weapon.Abstractweapon;

/**
 * A class that creates Swords.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */

public class Sword extends Abstractweapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name    name of sword
   * @param damage  damage, of sword
   * @param weight  weight of sword
   */
  public Sword(final String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage,0, weight, SWORD);
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