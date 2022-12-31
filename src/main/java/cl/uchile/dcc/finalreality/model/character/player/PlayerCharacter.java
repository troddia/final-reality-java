package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and Tomas Rodriguez
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magicspells.MagicSpell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

/**
 * A {@link GameCharacter} that can equip a weapon.
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips a weapon to the character.
   */
  void equip(Weapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();
  /**
   * Equips a spell
   */
  void equipSpell(MagicSpell spell);
  /**
   * Equips a spell
   */
  void useSpell(GameCharacter character);

  /**
   * Return this character actual spell.
   */
  MagicSpell getMagicSpell();
  /**
   * Returns the character's current MP.
   */

  public int getCurrentMp();
}
