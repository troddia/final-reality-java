package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.magicspells.typesmagic.ElectricMagicSpell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

  GameController controller;
  PlayerUser user;
  Weapon Axe;
  Weapon Staff;
  Weapon Sword;
  Weapon Knife;
  Weapon Bow;

  @BeforeEach
  public void setUp() throws InvalidStatValueException {
    controller = new GameController();
    user = PlayerUser.getInstance();
    //creates 7 enemies
    controller.StartGameConditions();
    this.Axe = new Axe("test_axe", 20, 10);
    this.Staff = new Staff("test_staff", 20, 10);
    this.Sword = new Sword("test_sword", 20, 10);
    this.Knife = new Knife("test_knife", 20, 10);
    this.Bow = new Knife("test_bow", 20, 10);
  }
  @Test
  void createEngineerPlayerchar() throws InvalidStatValueException {
    controller.createEngineerPlayerchar("TestEngineer", 100, 30, Axe);
    assertEquals("TestEngineer", controller.getPlayerchar(0).getName());
    assertEquals(100, controller.getPlayerchar(0).getCurrentHp());
    assertEquals(30, controller.getPlayerchar(0).getDefense());
    assertEquals(Axe, controller.getPlayerchar(0).getEquippedWeapon());
  }

  @Test
  void createKnightPlayerchar() throws InvalidStatValueException {
    controller.createKnightPlayerchar("TestKnight", 100, 30, Sword);
    assertEquals("TestKnight", controller.getPlayerchar(0).getName());
    assertEquals(100, controller.getPlayerchar(0).getCurrentHp());
    assertEquals(30, controller.getPlayerchar(0).getDefense());
    assertEquals(Sword, controller.getPlayerchar(0).getEquippedWeapon());
  }

  @Test
  void createThiefPlayerchar() throws InvalidStatValueException {
    controller.createThiefPlayerchar("TestThief", 100, 30, Bow);
    assertEquals("TestThief", controller.getPlayerchar(0).getName());
    assertEquals(100, controller.getPlayerchar(0).getCurrentHp());
    assertEquals(30, controller.getPlayerchar(0).getDefense());
    assertEquals(Bow, controller.getPlayerchar(0).getEquippedWeapon());
  }

  @Test
  void createBlackMagePlayerchar() throws InvalidStatValueException {
    controller.createBlackMagePlayerchar("Testbm", 100, 30,100, Staff);
    assertEquals("Testbm", controller.getPlayerchar(0).getName());
    assertEquals(100, controller.getPlayerchar(0).getCurrentHp());
    assertEquals(30, controller.getPlayerchar(0).getDefense());
    assertEquals(Staff, controller.getPlayerchar(0).getEquippedWeapon());
  }

  @Test
  void createWhiteMagePlayerchar() throws InvalidStatValueException {
    controller.createWhiteMagePlayerchar("Testwm", 100, 30,100, Staff);
    assertEquals("Testwm", controller.getPlayerchar(0).getName());
    assertEquals(100, controller.getPlayerchar(0).getCurrentHp());
    assertEquals(30, controller.getPlayerchar(0).getDefense());
    assertEquals(Staff, controller.getPlayerchar(0).getEquippedWeapon());
  }

  @Test
  void removePlayerchar() throws InvalidStatValueException {
    controller.createEngineerPlayerchar("TestEngineer", 100, 30, Axe);
    PlayerCharacter character = controller.getPlayerchar(0);
    controller.removePlayerchar(controller.getPlayerchar(0));
    assertFalse(controller.listcontains(controller.getPlayercharArraylist(), character));
  }

  @Test
  void getPlayerchar() throws InvalidStatValueException {
    controller.createKnightPlayerchar("TestKnight", 100, 30, Sword);
    assertEquals(new Knight("TestKnight", 100, 30, controller.getTurnsQueue()),controller.getPlayerchar(0));
  }

  @Test
  void eliminatePlayerCharIdx() throws InvalidStatValueException {
    controller.createEngineerPlayerchar("TestEngineer", 100, 30, Axe);
    PlayerCharacter character = controller.getPlayerchar(0);
    controller.eliminatePlayerCharIdx(0);
    assertFalse(controller.listcontains(controller.getPlayercharArraylist(), character));
  }

  @Test
  void createEnemy() throws InvalidStatValueException {
    //there already are enemies in list.
    controller.createEnemy("test_enemy",50, 100,40,40);
    assertEquals("test_enemy", controller.getEnemychar(7).getName());
    assertEquals(100, controller.getEnemychar(7).getCurrentHp());
    assertEquals(40, controller.getEnemychar(7).getDefense());
    assertEquals(40, controller.getEnemychar(7).getDamage());
  }

  @Test
  void removeEnemychar() throws InvalidStatValueException {
    Enemy character = controller.getEnemychar(0);
    controller.removeEnemychar(controller.getEnemychar(0));
    assertFalse(controller.listcontains(controller.getEnemycharArraylist(), character));
  }

  @Test
  void getEnemychar() throws InvalidStatValueException {
    controller.createEnemy("test_enemy",50, 100,40,40);
    assertEquals(new Enemy("test_enemy",50, 100,40,40, controller.getTurnsQueue()),controller.getEnemychar(7));
  }

  @Test
  void eliminateEnemychar() {
    Enemy character = controller.getEnemychar(0);
    controller.eliminateEnemychar(0);
    assertFalse(controller.listcontains(controller.getEnemycharArraylist(), character));
  }

  @Test
  void addWeapon() throws InvalidStatValueException {
    Weapon w = new Sword("add test",50,50);
    controller.addWeapon(w);
    assertTrue(controller.listcontains(controller.getWeaponInventory(),w ));
  }

  @Test
  void getWeapon() throws InvalidStatValueException {
    Weapon w = new Sword("get test",50,50);
    controller.addWeapon(w);
    assertEquals(controller.getWeapon(0),w);
  }

  @Test
  void deleteweapon() throws InvalidStatValueException {
    Weapon w = new Sword("get test",50,50);
    controller.addWeapon(w);
    controller.deleteweapon(0);
    assertFalse(controller.listcontains(controller.getWeaponInventory(),w));
  }

  @Test
  void changeWeapon() throws InvalidStatValueException {
    controller.createEngineerPlayerchar("TestEngineer", 100, 30, Axe);
    Weapon w = new Axe("changed axe",50,50);
    controller.addWeapon(w);
    Weapon prev = controller.getPlayerchar(0).getEquippedWeapon();
    controller.changeWeapon(0,0);
    assertEquals(controller.getPlayerchar(0).getEquippedWeapon(),w,"the weapon is changed");
    assertTrue(controller.listcontains(controller.getWeaponInventory(),prev), "the previusly used is added to inventory");
  }

  @Test
  void attack() throws InvalidStatValueException {
    controller.createEngineerPlayerchar("TestEngineer", 100, 30, Axe);
    controller.createEnemy("test_enemy",50, 100,40,40);
    controller.attack(controller.getPlayerchar(0), controller.getEnemychar(7) );
    assertEquals(80 ,controller.getEnemychar(7).getCurrentHp(), "Axe damage is 20");
    controller.attack(controller.getEnemychar(7), controller.getPlayerchar(0) );
    assertEquals(60 ,controller.getPlayerchar(0).getCurrentHp(), "Enemy damage is 40");

  }

  @Test
  void useBlackMagic() throws InvalidStatValueException {
    controller.createBlackMagePlayerchar("Testbm", 100, 30,100, Staff);
    controller.createEnemy("test_enemy",50, 100,40,40);
    controller.useBlackMagic(controller.getPlayerchar(0),controller.getEnemychar(7),0);//0 is electric and 1 fire
    assertEquals(80,controller.getEnemychar(7).getCurrentHp(), "staff has 20 magicdamage");
    assertEquals(85,controller.getPlayerchar(0).getCurrentMp(), "mp cost of electric is 15");

  }

  @Test
  void useWhiteMagic() throws InvalidStatValueException {
    controller.createWhiteMagePlayerchar("Testbm", 100, 30,100, Staff);
    controller.createWhiteMagePlayerchar("Testbm", 100, 30,100, Staff);
    controller.getPlayerchar(1).setCurrentHp(30);
    //heal is idx 0, poison 1 and paralysis 2
    controller.useWhiteMagic(controller.getPlayerchar(0),controller.getPlayerchar(1),0);
    assertEquals(60,controller.getPlayerchar(1).getCurrentHp(), "30% of maxhp is 30");
    assertEquals(85,controller.getPlayerchar(0).getCurrentMp(), "mp cost of heal is 15");
  }
  @DisplayName("Printea si muere enemigo")
  @Test
  void notifyEndUserTurn() throws InvalidStatValueException {
    Weapon killingAxe = new Axe("kill",200,50);
    controller.createEngineerPlayerchar("TestEngineer", 100, 30, killingAxe);
    controller.createEnemy("test_enemy",50, 100,40,40);
    Enemy e = controller.getEnemychar(7);
    controller.attack(controller.getPlayerchar(0), controller.getEnemychar(7));
    controller.notifyEndUserTurn();

  }
  @DisplayName("Printea si muere personaje")
  @Test
  void notifyEndEnemyTurn() throws InvalidStatValueException {
    controller.createEngineerPlayerchar("TestEngineer", 100, 30, Axe);
    controller.createEnemy("kill",50, 100,40,200);
    PlayerCharacter p = controller.getPlayerchar(0);
    controller.attack( controller.getEnemychar(7), controller.getPlayerchar(0));
    controller.notifyEndEnemyTurn();
  }
}