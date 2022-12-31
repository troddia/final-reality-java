package cl.uchile.dcc.finalreality.model.character.player.magecharacter;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.magicspells.MagicSpell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that extends from  {@link PlayerCharacter}
 * that holds the information of a mage player-controlled character in the game.*
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */

public abstract class AbstractMage extends AbstractPlayerCharacter implements
        Mage {

  protected int currentMp;
  protected final int maxMp;
  protected MagicSpell equippedSpell = null;

  /**
   * Creates a new Black Mage.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   * @param maxMp      the character's max Mp
   */

  protected AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                         int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }
  // region : ACCESSORS

  /**
   * Returns the character's current MP.
   */

  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Sets the character's current MP.
   */

  public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    try {
      Require.statValueAtMost(maxMp, currentMp, "Current MP");
      this.currentMp = currentMp;
    } catch (Exception e) {
      this.currentMp = maxMp;
    }
  }

  /**
   * Returns the character's max MP.
   */

  public int getMaxMp() {
    return maxMp;
  }

  @Override
  public MagicSpell getMagicSpell() {
    return equippedSpell;
  }

  @Override
  public void useSpell(GameCharacter character){
      currentMp-= equippedSpell.getMpCost();
      equippedSpell.spellefect(equippedWeapon, character);
      equippedSpell = null;
  }

}
