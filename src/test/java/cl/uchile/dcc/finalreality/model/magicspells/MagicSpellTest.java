package cl.uchile.dcc.finalreality.model.magicspells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.WhiteMage;
import cl.uchile.dcc.finalreality.model.magicspells.typesmagic.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class MagicSpellTest {
  MagicSpell electrocute;
  MagicSpell fire;
  MagicSpell heal;
  MagicSpell paralysis;
  MagicSpell poison;
  PlayerCharacter whitemage;
  PlayerCharacter blackmage;
  Weapon staff;

  @BeforeEach
  void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
    electrocute = new ElectricMagicSpell();
    fire = new FireMagicSpell();
    heal = new HealMagicSpell();
    paralysis = new ParalysisMagicSpell();
    poison = new PoisonMagicSpell();
    blackmage = new BlackMage("BM",100,10,10,q);
    whitemage = new WhiteMage("WM",100,10,10,q);
    staff = new Staff("staff", 10, 10);
  }

  @Test
  void spelluseBlackmage() {
    assertEquals(electrocute, electrocute.spelluseBlackmage(blackmage));
    assertEquals(fire, fire.spelluseBlackmage(blackmage));
    assertEquals(null, heal.spelluseBlackmage(blackmage));
    assertEquals(null, paralysis.spelluseBlackmage(blackmage));
    assertEquals(null, poison.spelluseBlackmage(blackmage));
  }

  @Test
  void spelluseWhitemage() {
    assertEquals(null, electrocute.spelluseWhitemage(whitemage));
    assertEquals(null, fire.spelluseWhitemage(whitemage));
    assertEquals(heal, heal.spelluseWhitemage(whitemage));
    assertEquals(paralysis, paralysis.spelluseWhitemage(whitemage));
    assertEquals(poison, poison.spelluseWhitemage(whitemage));
  }

  @Test
  void spellefectDamage() {
    electrocute.spellefect(staff, blackmage);
    assertEquals(90, blackmage.getCurrentHp(), "10 damage to blackmage");
    fire.spellefect(staff,blackmage);
    assertEquals(80, blackmage.getCurrentHp(), "10 damage to blackmage with 90 hp");
    heal.spellefect(staff,blackmage);
    assertEquals(blackmage.getMaxHp(), blackmage.getCurrentHp(), "heals maxhp/3 and if currenthp>maxhp, currenthp=maxhp");
    poison.spellefect(staff,blackmage);
    assertEquals(97, blackmage.getCurrentHp(), "10/3 is the damage");

  }

  @Test
  void getMpCost() {
    assertEquals(15, electrocute.getMpCost());
    assertEquals(15, fire.getMpCost());
    assertEquals(15, heal.getMpCost());
    assertEquals(25, paralysis.getMpCost());
    assertEquals(40, poison.getMpCost());
  }
}