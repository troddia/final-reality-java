package cl.uchile.dcc.finalreality.model.magicspells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

public interface MagicSpell {
  /**
   * method to delegate the use of
   * the spell to the BlackMage that will
   * use it.
   */
  MagicSpell spelluseBlackmage(GameCharacter character);

  /**
   * method to delegate the use of
   * the spell to the WhiteMage that will
   * use it.
   */
  MagicSpell spelluseWhitemage(GameCharacter character);

  /**
   * Manages the after effetcs of
   * of the spell. (Specifically Enemy)
   */
  void spellefect(Weapon weapon, GameCharacter character);
  /**
   * Returns the cost
   * of the magic spell
   */
  int getMpCost();
}
