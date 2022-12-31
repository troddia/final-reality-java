package cl.uchile.dcc.finalreality.model.magicspells.typesmagic;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magicspells.AbstractMagicSpell;
import cl.uchile.dcc.finalreality.model.magicspells.MagicSpell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

public class ElectricMagicSpell extends AbstractMagicSpell {
  int cost = 15;
  public ElectricMagicSpell(){
  }

  @Override
  public MagicSpell spelluseBlackmage(GameCharacter character) {
    return this;
  }

  @Override
  public void spellefect(Weapon weapon, GameCharacter character) {
    character.recieveDamage(weapon.getMagicDamage());
    if(Math.random()< 0.3) {
      character.paralysis();
    }
  }


  @Override
  public int getMpCost() {
    return cost;
  }
}
