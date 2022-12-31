/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.exceptions;

/**
 * Class containing a series of methods to check if a condition is met.
 * If the condition is not met, an exception is thrown.
 *
 * <p>This class is {@code final} because it should not be extended.
 * All members of this class should be {@code static} because it is not meant to be
 * instantiated.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public final class Require {

  /**
   * Private constructor to avoid class instantiation.
   */
  private Require() {
  }

  /**
   * Checks if a given <i>Stat</i> value is <b>at least</b> a given value.
   *
   * @param least
   *     The smallest value (inclusive) that the <i>Stat</i> can have.
   * @param actualStat
   *     The actual value of the <i>Stat</i>.
   * @param statName
   *     The name of the <i>Stat</i>.
   * @throws InvalidStatValueException
   *     If the {@code actualStat} is less than {@code least}.
   */
  public static void statValueAtLeast(int least, int actualStat, String statName)
      throws InvalidStatValueException {
    if (least > actualStat) {
      throw new InvalidStatValueException(
          "'%s'(%d) must be at least %d".formatted(statName, actualStat, least));
    }
  }

  /**
   * Checks if a given <i>Stat</i> value is <b>at most</b> a given value.
   *
   * @param most
   *     The largest value (inclusive) that the <i>Stat</i> can have.
   * @param actualStat
   *     The actual value of the <i>Stat</i>.
   * @param statName
   *     The name of the <i>Stat</i>.
   * @throws InvalidStatValueException
   *     If the {@code actualStat} is greater than {@code most}.
   */
  public static void statValueAtMost(final int most, final int actualStat,
      final String statName) throws InvalidStatValueException {
    if (most < actualStat) {
      throw new InvalidStatValueException(
          "'%s'(%d) must be at most %d".formatted(statName, actualStat, most));
    }
  }
}
