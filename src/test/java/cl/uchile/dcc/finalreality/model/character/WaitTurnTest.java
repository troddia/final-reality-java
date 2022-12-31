package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitTurnTest {

    Weapon weapon;
    PlayerCharacter player;
    GameCharacter enemy;
    ArrayList<GameCharacter> list;
    int[] listnum;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        list = new ArrayList<GameCharacter>(10);
        listnum = new int[]{10, 20, 30, 40, 50};
    }

    @Test
    @DisplayName("QueueTest with enemy and playercharacter, also checks order")
    void queueTest() throws InvalidStatValueException, InterruptedException {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        for (int i = 0; i < 4; i++) {
            player = new Engineer(Integer.toString(listnum[i]), 10, 10, q);
            weapon = new Axe("axe", 10, listnum[i]);
            player.equip(weapon);
            player.waitTurn();
        }
        enemy = new Enemy(Integer.toString(listnum[4]),listnum[4],10,10, 10, q);
        enemy.waitTurn();
        Thread.sleep(6000);
        while (!q.isEmpty()) {
            // Pops and prints the names of the characters of the queue to illustrate the turns
            // order
            list.add(q.poll());
        }

        assertEquals("10",list.get(0).getName());
        assertEquals("20",list.get(1).getName());
        assertEquals("30",list.get(2).getName());
        assertEquals("40",list.get(3).getName());
        assertEquals("50",list.get(4).getName());

    }

}
