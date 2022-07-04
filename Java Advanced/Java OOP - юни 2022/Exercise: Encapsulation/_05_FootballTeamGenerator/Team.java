package EncapsulationExercise.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        if (!players.removeIf(s -> s.getName().equals(name))) {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.getName() + " team.");
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
