package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */

public interface GameCharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Sets this character's current HP to {@code newHp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;
  /**
   * Implements basic attack method.
   */
  void attack(GameCharacter gamecharacter);
  /**
   * recieveAttack to take damage
   * from attack.
   */
  void recieveDamage(int damage);
  /**
   * Method to check state of
   * gamecharacter, dead or alive.
   */
  boolean isAlive();
  /**
   * After effects of spells,
   * missing a turn, taking damage
   * for each turn. (must implement
   * along the lines of turn based state pattern)
   */
  void paralysis();
  void poisoning(int magicdamage);
  void burning(int magicdamage);
  void heal(double percentage);
  void update(GameController controller);


}
