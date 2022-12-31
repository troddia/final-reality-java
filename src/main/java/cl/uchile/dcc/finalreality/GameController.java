package cl.uchile.dcc.finalreality;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.WhiteMage;
import cl.uchile.dcc.finalreality.model.magicspells.MagicSpell;
import cl.uchile.dcc.finalreality.model.magicspells.typesmagic.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that creates controller and uses observer and state pattern.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */
public class GameController {
  private BlockingQueue<GameCharacter> turnsQueue = new LinkedBlockingQueue<>();
  private List<PlayerCharacter> playerCharacters = new ArrayList<PlayerCharacter>();
  private List<Enemy> enemyCharacters = new ArrayList<Enemy>();
  private List<Weapon> weaponInventory = new ArrayList<Weapon>();
  private List<MagicSpell> blackmagic = new ArrayList<MagicSpell>();
  private List<MagicSpell> whitemagic = new ArrayList<MagicSpell>();
  PlayerUser user;
  private boolean victory = false;
  private boolean defeat = false;

  /**
   * Creates a controller and adds all spells.
   *
   */

  public GameController() throws InvalidStatValueException {
    blackmagic.add(new ElectricMagicSpell());
    blackmagic.add(new FireMagicSpell());
    whitemagic.add(new HealMagicSpell());
    whitemagic.add(new PoisonMagicSpell());
    whitemagic.add(new ParalysisMagicSpell());
  }
  /**
   * Starts game and adds 7 enemies to game.
   */
  public void StartGameConditions() throws InvalidStatValueException {
    enemyCharacters.add(new Enemy("Enemy 0",50,100,70,60,turnsQueue));
    enemyCharacters.add(new Enemy("Enemy 1",40,70,20,30,turnsQueue));
    enemyCharacters.add(new Enemy("Enemy 2",50,80,70,60,turnsQueue));
    enemyCharacters.add(new Enemy("Enemy 3",50,100,70,60,turnsQueue));
    enemyCharacters.add(new Enemy("Enemy 4",50,100,70,60,turnsQueue));
    enemyCharacters.add(new Enemy("Enemy 5",50,100,70,60,turnsQueue));
    enemyCharacters.add(new Enemy("Enemy 6",50,100,70,60,turnsQueue));


  }
  /**
   * checks if object is in list.
   */
  public boolean listcontains(List a, Object o ){
    return a.contains(o);
  }

  /**
   * Return this playercharacterlist.
   */
  public List<PlayerCharacter> getPlayercharArraylist(){
    return playerCharacters;
  }

  /**
   * Return this enemylist.
   */
  public List<Enemy> getEnemycharArraylist(){
    return enemyCharacters;
  }

  /**
   * Return this Weaponlist.
   */
  public List<Weapon> getWeaponInventory(){
    return weaponInventory;
  }

  /**
   * Return this turnsqueue.
   */
  public BlockingQueue<GameCharacter>  getTurnsQueue(){
    return turnsQueue;
  }

  /**
   * creates engineer with weapon and adds to playercharlist.
   */
  public void createEngineerPlayerchar(String name, int hp, int defence, Weapon weapon) throws InvalidStatValueException {
      PlayerCharacter playerchar = new Engineer(name, hp, defence, turnsQueue);
      playerchar.equip(weapon);
      playerCharacters.add(playerchar);
  }

  /**
   * creates knight with weapon and adds to playercharlist.
   */
  public void createKnightPlayerchar(String name, int hp, int defence, Weapon weapon) throws InvalidStatValueException {
    PlayerCharacter playerchar = new Knight(name, hp, defence,turnsQueue);
    playerchar.equip(weapon);
    playerCharacters.add(playerchar);
  }

  /**
   * creates thief with weapon and adds to playercharlist.
   */
  public void createThiefPlayerchar(String name, int hp, int defence, Weapon weapon) throws InvalidStatValueException {
    PlayerCharacter playerchar = new Thief(name, hp, defence,turnsQueue);
    playerchar.equip(weapon);
    playerCharacters.add(playerchar);
  }

  /**
   * creates blackmage with weapon and adds to playercharlist.
   */
  public void createBlackMagePlayerchar(String name, int hp, int defence, int mp, Weapon weapon) throws InvalidStatValueException {
    PlayerCharacter playerchar = new BlackMage(name, hp, defence, mp,turnsQueue);
    playerchar.equip(weapon);
    playerCharacters.add(playerchar);
  }

  /**
   * creates whitemage with weapon and adds to playercharlist.
   */
  public void createWhiteMagePlayerchar(String name, int hp, int defence, int mp, Weapon weapon) throws InvalidStatValueException {
    PlayerCharacter playerchar = new WhiteMage(name, hp, defence, mp,turnsQueue);
    playerchar.equip(weapon);
    playerCharacters.add(playerchar);
  }

  /**
   * removes from playerchar list with object.
   */
  public void removePlayerchar(PlayerCharacter playerchar){
    playerCharacters.remove(playerchar);
  }

  /**
   * gets playercharacter from respective list
   */
  public PlayerCharacter getPlayerchar(int playercharidx){
    return playerCharacters.get(playercharidx);
  }

  /**
   * removes from playerchar list with the playerchar index.
   */
  public void eliminatePlayerCharIdx(int playercharidx){
    playerCharacters.remove(playercharidx);
  }


  /**
   * Creates an enemy and adds to enemlist.
   */
  public void createEnemy(String name, int weight, int hp, int defense, int damage) throws InvalidStatValueException {
    Enemy enemychar = new Enemy(name, weight, hp, defense, damage,turnsQueue);
    enemyCharacters.add(enemychar);
  }

  /**
   * removes from enemycharlist list with object.
   */
  public void removeEnemychar(Enemy enemychar){
    enemyCharacters.remove(enemychar);
  }

  /**
   * gets enemy from respective list by index.
   */
  public Enemy getEnemychar(int enemyidx){
    return enemyCharacters.get(enemyidx);
  }

  /**
   * removes from enemycharlist list with index.
   */
  public void eliminateEnemychar(int enemyidx){
    enemyCharacters.remove(enemyidx);
  }

  /**
   * adds weapon to weaponInventory.
   */
  public void addWeapon(Weapon weapon){
    weaponInventory.add(weapon);
  }

  /**
   * gets weapon from weaponInventory.
   */
  public Weapon getWeapon(int weaponidx){
    return weaponInventory.get(weaponidx);
  }

  /**
   * removes weapon from weaponInventory.
   */
  public void deleteweapon(int weaponidx){
    weaponInventory.remove(weaponidx);
  }

  /**
   * changes weapon from playerchar.
   */
  public void changeWeapon(int weaponidx, int charidx){
    Weapon eqweapon = playerCharacters.get(charidx).getEquippedWeapon();
    addWeapon(eqweapon);
    playerCharacters.get(charidx).equip(getWeapon(weaponidx));
    if(playerCharacters.get(charidx).getEquippedWeapon().equals(getWeapon(weaponidx))){
      deleteweapon(weaponidx);
    }
  }

  /**
   * game character attacks another gamecharacter.
   */
  public void attack(GameCharacter attacker, GameCharacter target) {
    attacker.attack(target);
  }

  /**
   * uses a spell by index like an attack with spell in  black magic list.
   */
  public void useBlackMagic(PlayerCharacter attacker, GameCharacter target, int spellidx) {
    attacker.equipSpell(blackmagic.get(spellidx));
    attacker.useSpell(target);
  }

  /**
   * uses a spell by index like an attack with spell in white magic list.
   */
  public void useWhiteMagic(PlayerCharacter attacker, GameCharacter target, int spellidx) {
    attacker.equipSpell(whitemagic.get(spellidx));
    attacker.useSpell(target);
  }


  //observer pattern where controller is the publisher and enemies and playercharacters are
  // the suscribers para los casos donde se mueren personajes.
  /**
   * gamecharacter waitturn.
   */
  public void waitTurn(GameCharacter gameCharacter) {
    gameCharacter.waitTurn();
  }

  /**
   * observer pattern where controller is the publisher and enemies and playercharacters are
   * the suscribers. This notifies enemy characters to check wich ones died with attack.
   */
  public void notifyEndUserTurn() {
    for (Enemy listener: enemyCharacters) {
      listener.update(this);
    }
  }

  /**
   * observer pattern where controller is the publisher and enemies and playercharacters are
   * the suscribers. This notifies Player characters to check wich ones died with attack.
   */
  public void notifyEndEnemyTurn() {
    //at the end of the enemy attack player characters must upadate.
    for (PlayerCharacter listener: playerCharacters) {
      listener.update(this);
    }
  }

  /**
   * Checks state of outcome, victory or defeat.
   */
  public void checkWinner() {
    if(enemyCharacters.isEmpty() && playerCharacters.size()>0){
      victory = true;
    }
    else{
      defeat = true;
    }

    }
}


