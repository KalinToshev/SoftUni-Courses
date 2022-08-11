package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {

    private boolean isLive(List<Player> players) {
        return players.stream().mapToInt(Player::getHealth).sum() > 0;
    }

    private void attack(List<Player> attackingPlayers, List<Player> attackedPlayers) {
        for (Player attackingPlayer : attackingPlayers) {
            if (attackingPlayer.isAlive()) {
                for (Player attackedPlayer : attackedPlayers) {
                    if (attackedPlayer.isAlive()) {
                        int damagePoints = attackingPlayer.getGun().fire();
                        attackedPlayer.takeDamage(damagePoints);
                    }
                }
            }
        }
    }

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream()
                .filter(player -> player.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());

        List<Player> counter_terrorists = players.stream()
                .filter(player -> player.getClass().getSimpleName().equals("CounterTerrorist"))
                .collect(Collectors.toList());

        while (isLive(terrorists) && isLive(counter_terrorists)) {
            attack(terrorists, counter_terrorists);
            attack(counter_terrorists, terrorists);
        }

        if(isLive(terrorists)) {
            return TERRORIST_WINS;
        }

        return COUNTER_TERRORIST_WINS;
    }
}
