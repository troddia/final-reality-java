package cl.uchile.dcc.finalreality.model.character.player.magecharacter;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.magicspells.MagicSpell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;


/**
 * A {@link PlayerCharacter} that has MP.
 */

public interface Mage extends PlayerCharacter {

  /**
   * Returns this character's max MP.
   */
  int getMaxMp();

  /**
   * Sets this character's current MP to {@code newHp}.
   */
  void setCurrentMp(int mp) throws InvalidStatValueException;
}