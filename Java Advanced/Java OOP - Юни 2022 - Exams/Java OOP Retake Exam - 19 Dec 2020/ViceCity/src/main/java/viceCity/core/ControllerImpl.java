package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayDeque;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private ArrayDeque<Player> civilPlayers;
    private GunRepository gunRepository;
    private MainPlayer mainPlayer;

    public ControllerImpl() {
        this.civilPlayers = new ArrayDeque<>();
        this.gunRepository = new GunRepository();
        this.mainPlayer = new MainPlayer();
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer civilPlayer = new CivilPlayer(name);
        civilPlayers.offer(civilPlayer);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if(gunRepository.getModels().isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if("Vercetti".equals(name)){
            Gun gun = gunRepository.getModels().poll();
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        Player civilPlayer = civilPlayers.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
        if(civilPlayer == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        Gun gun = gunRepository.getModels().poll();
        civilPlayer.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
    }

    @Override
    public String fight() {
        int civilPlayersLifeBeforeFight = civilPlayers.stream().mapToInt(Player::getLifePoints).sum();

        GangNeighbourhood fightArena = new GangNeighbourhood();
        fightArena.action(mainPlayer, civilPlayers);

        int civilPlayersLifeAfterFight = civilPlayers.stream().mapToInt(Player::getLifePoints).sum();

        if(mainPlayer.getLifePoints() == 100
                && civilPlayersLifeBeforeFight == civilPlayersLifeAfterFight) {
            return FIGHT_HOT_HAPPENED;
        } else {
            return FIGHT_HAPPENED + System.lineSeparator() +
                    String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()) + System.lineSeparator() +
                    String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, fightArena.getDeadCivilPlayer()) + System.lineSeparator() +
                    String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size());
        }
    }
}
