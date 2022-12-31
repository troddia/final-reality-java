package cl.uchile.dcc.finalreality.model.magicspells.typesmagic;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magicspells.AbstractMagicSpell;
import cl.uchile.dcc.finalreality.model.magicspells.MagicSpell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

public class FireMagicSpell extends AbstractMagicSpell {
  int cost = 15;
  public FireMagicSpell(){
  }

  @Override
  public MagicSpell spelluseBlackmage(GameCharacter character) {
    return this;
  }

  @Override
  public void spellefect(Weapon weapon, GameCharacter character) {
    character.recieveDamage(weapon.getMagicDamage());
    if(Math.random()< 0.2) {
      character.burning(weapon.getMagicDamage());
    }
  }


  @Override
  public int getMpCost() {
    return cost;
  }
}
