package cl.uchile.dcc.finalreality;

/**
 * A class that creates user and uses singleton pattern.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Tomas Rodriguez
 */
public class PlayerUser {
  /**
   * Creates a User.
   *
   */
  static PlayerUser User = new PlayerUser();
  private String username;

  private PlayerUser() {
  }

  public static PlayerUser getInstance() {
    return User;
  }

  public void setUsername(String name) {
    this.username = name;
  }
  // maybe not needed but still looks right if I alter the privileges.




}
