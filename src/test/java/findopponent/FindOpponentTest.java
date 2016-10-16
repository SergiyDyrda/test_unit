package findopponent;

import findopponent.model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Sergiy on 16.10.2016.
 */
public class FindOpponentTest {
    private final Player player1 = new Player("player1", 1.3);
    private final Player player2 = new Player("player2", 1.45);
    private final Player player3 = new Player("player3", 1.73);
    private final Player player4 = new Player("player4", 1.14);
    private final Player player5 = new Player("player5", 1.0);
    private final Player player6 = new Player("player6", 1.99);

    private final FindOpponent findOpponentService = new FindOpponent();

    @Before
    public void setUp() throws Exception {
        findOpponentService.clearPlayerSet();
        findOpponentService.addAllPlayers(player1, player2, player3, player4, player5, player6);
    }

    @Test
    public void findOpponent_1() throws Exception {
        assertEquals(player2, findOpponentService.findOpponent(player1));
        assertFalse(findOpponentService.containsPlayer(player2));

    }

    @Test
    public void findOpponent_2() throws Exception {
        assertEquals(player5, findOpponentService.findOpponent(player4));
        assertFalse(findOpponentService.containsPlayer(player5));
    }

    @Test
    public void findOpponent_3() throws Exception {
        assertEquals(player6, findOpponentService.findOpponent(player3));
        assertFalse(findOpponentService.containsPlayer(player6));

    }

    @Test
    public void findOpponent_4() throws Exception {
        assertEquals(player4, findOpponentService.findOpponent(player5));
        assertFalse(findOpponentService.containsPlayer(player4));

    }

    @Test
    public void findOpponent_5() throws Exception {
        assertEquals(player3, findOpponentService.findOpponent(player6));
        assertFalse(findOpponentService.containsPlayer(player3));

    }
}