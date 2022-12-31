package cl.uchile.dcc.finalreality.model.magicspells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

public abstract class AbstractMagicSpell implements MagicSpell {

  public AbstractMagicSpell() {
  }

  @Override
  public MagicSpell spelluseBlackmage(GameCharacter character) {
    return null;
  }

  @Override
  public MagicSpell spelluseWhitemage(GameCharacter character) {
    return null;
  }
}

