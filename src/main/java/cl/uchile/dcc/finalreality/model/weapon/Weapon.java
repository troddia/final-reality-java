package cl.uchile.dcc.finalreality.model.weapon;


/**
 * This represents a weapon from the game.
 * Each Weapon has a different type.
 *
 */

public interface Weapon {


  /**
   * Returns the name of the weapon.
   */
  String getName();
  /**
   * Returns the Damage, of the weapon.
   */

  int getDamage();
  /**
   * Returns the Magic damage, of the weapon.
   */

  int getMagicDamage();
  /**
   * Returns the Weight of the weapon.
   */

  int getWeight();

  /**
   * Returns the type of the weapon.
   */
  WeaponType getType();

  /**
   * Returns boolean of if a weapon
   * is usable by a BlackMage.
   */
  boolean usableBlackmageWeapon();

  /**
   * Returns boolean of if a weapon
   * is usable by a WhiteMage.
   */
  boolean usableWhitemageWeapon();

  /**
   * Returns boolean of if a weapon
   * is usable by a Knight.
   */
  boolean usableKnightWeapon();

  /**
   * Returns boolean of if a weapon
   * is usable by an Engineer.
   */
  boolean usableEngineerWeapon();

  /**
   * Returns boolean of if a weapon
   * is usable by a Thief.
   */
  boolean usableThiefWeapon();
}
