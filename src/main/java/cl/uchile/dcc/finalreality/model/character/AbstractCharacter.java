package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of the characters
 * in the game (except waitTurn()).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */
public abstract class AbstractCharacter implements GameCharacter {

  protected int currentHp;
  protected int maxHp;
  protected int defense;
  protected final BlockingQueue<GameCharacter> turnsQueue;
  protected final String name;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.name = name;
  }



  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    try {
      Require.statValueAtMost(maxHp, hp, "Current HP");
      currentHp = hp;
    } catch (Exception e) {
      currentHp = maxHp;
    }
  }

  @Override
  public void recieveDamage(int damage) {
    currentHp -= damage;
  }

  @Override
  public void paralysis() {
    //can not attack next turn
  }

  @Override
  public void poisoning(int magicdamage) {
    recieveDamage(magicdamage/3);
    //cambiar el state, para que el proximo turno
  }

  @Override
  public void burning(int magicdamage) {
    recieveDamage(magicdamage/2);
  }
  @Override
  public void heal(double percentage) {
    currentHp+= percentage*maxHp;
    if(currentHp>maxHp){
      currentHp=maxHp;
    }
  }


  @Override
  public boolean isAlive(){
    return currentHp > 0;
  }
}
