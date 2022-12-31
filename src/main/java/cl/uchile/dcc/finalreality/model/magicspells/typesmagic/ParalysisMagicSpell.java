package cl.uchile.dcc.finalreality.model.magicspells.typesmagic;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magicspells.AbstractMagicSpell;
import cl.uchile.dcc.finalreality.model.magicspells.MagicSpell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

public class ParalysisMagicSpell extends AbstractMagicSpell {
  int cost = 25;
  public ParalysisMagicSpell(){
  }

  @Override
  public MagicSpell spelluseWhitemage(GameCharacter character) {
    return this;
  }

  @Override
  public void spellefect(Weapon weapon, GameCharacter character) {
    character.paralysis();
  }


  @Override
  public int getMpCost() {
    return cost;
  }
}
