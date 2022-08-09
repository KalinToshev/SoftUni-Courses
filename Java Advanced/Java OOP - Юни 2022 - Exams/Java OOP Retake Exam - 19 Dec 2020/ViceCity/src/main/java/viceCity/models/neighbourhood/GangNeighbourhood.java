package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayDeque;

public class GangNeighbourhood implements Neighbourhood {
    int deadCivilPlayer;

    public int getDeadCivilPlayer() {
        return deadCivilPlayer;
    }

    @Override
    public void action(Player mainPlayer, ArrayDeque<Player> civilPlayers) {
        mainPlayerShoot(mainPlayer, civilPlayers);
        civilPlayersShoot(mainPlayer, civilPlayers);
    }

    private void mainPlayerShoot(Player mainPlayer, ArrayDeque<Player> civilPlayers) {
        for (Gun gun : mainPlayer.getGunRepository().getModels()) {
            while (gun.canFire() && !civilPlayers.isEmpty()) {
                Player civilPlayer = civilPlayers.peek();
                while (civilPlayer.isAlive() && gun.canFire()) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
                if (!civilPlayer.isAlive()) {
                    civilPlayers.poll();
                    deadCivilPlayer++;
                }
            }
            if (civilPlayers.isEmpty()) {
                break;
            }
        }
    }

    private void civilPlayersShoot(Player mainPlayer, ArrayDeque<Player> civilPlayers) {
        if (!civilPlayers.isEmpty()) {
            for (Player civilPlayer : civilPlayers) {
                for (Gun model : civilPlayer.getGunRepository().getModels()) {
                    while (mainPlayer.isAlive() && model.canFire()) {
                        mainPlayer.takeLifePoints(model.fire());
                    }
                }
            }
        }

    }
}
