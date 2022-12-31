package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.Objects;

/**
 * An Abstract class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class Abstractweapon implements Weapon {

  protected final String name;
  protected final int damage;
  protected final int magicdamage;
  protected final int weight;
  protected final WeaponType type;



  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public Abstractweapon(final String name, final int damage, final int magicdamage, final int weight, WeaponType type)
          throws InvalidStatValueException {
    Require.statValueAtLeast(0, damage, "damage");
    Require.statValueAtLeast(0,magicdamage , "damage");
    Require.statValueAtLeast(1, weight, "weight");
    this.name = name;
    this.damage = damage;
    this.magicdamage = magicdamage;
    this.weight = weight;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public int getDamage() {
    return damage;
  }
  public int getMagicDamage(){return magicdamage;};

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }
  /**
   * Returns the type of the weapon.
   */

  public WeaponType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, magicdamage=%d, weight=%d, type=%s}"
            .formatted(name, damage,magicdamage, weight, type);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Abstractweapon that)) {
      return false;
    }
    return damage == that.damage && magicdamage == that.magicdamage && weight == that.weight
            && Objects.equals(name, that.name) && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, damage,magicdamage, weight, type);
  }

  @Override
  public boolean usableBlackmageWeapon() {
    return false;
  }

  @Override
  public boolean usableWhitemageWeapon() {
    return false;
  }

  @Override
  public boolean usableKnightWeapon() {
    return false;
  }

  @Override
  public boolean usableEngineerWeapon() {
    return false;
  }

  @Override
  public boolean usableThiefWeapon() {
    return false;
  }
}
