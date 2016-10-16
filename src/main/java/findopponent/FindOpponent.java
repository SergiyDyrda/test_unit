package findopponent;

import findopponent.model.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Sergiy on 16.10.2016.
 */
public class FindOpponent {
    private final Set<Player> players = new HashSet<>();

    public void addAllPlayers(Player...playerSet) {
        players.addAll(Arrays.asList(playerSet));
    }

    public Player findOpponent(Player player) {
        Objects.requireNonNull(player);
        Player opponent = null;
        double delta = Double.MAX_VALUE;

        for (Player currentPlayer : players) {
            if (!currentPlayer.equals(player)) {
                double currentDelta = Math.abs(currentPlayer.getRating() - player.getRating());
                if (currentDelta < delta) {
                    delta = currentDelta;
                    opponent = currentPlayer;
                }
            }
        }

        if (opponent != null) {
            players.remove(opponent);
        }

        return opponent;
    }

    public boolean containsPlayer(Player player) {
        return players.contains(player);
    }

    public void clearPlayerSet() {
        players.clear();
    }
}
