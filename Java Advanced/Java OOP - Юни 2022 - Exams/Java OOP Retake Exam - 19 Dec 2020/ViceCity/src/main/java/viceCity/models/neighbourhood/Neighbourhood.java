package viceCity.models.neighbourhood;

import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, ArrayDeque<Player> civilPlayers);
}
