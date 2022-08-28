package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int sumEnergy() {
        return supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        //"{fieldName} ({fieldType}):
        //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
        //Supplement: {supplementsCount}
        //Energy: {sumEnergy}"
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" ").append("(").append(getClass().getSimpleName()).append("):").append(System.lineSeparator());
        stringBuilder.append("Player: ");
        if (this.players.isEmpty()) {
            stringBuilder.append("none").append(System.lineSeparator());
        } else {
            stringBuilder.append(players.stream().map(Player::getName).collect(Collectors.joining(" "))).append(System.lineSeparator());
        }
        stringBuilder.append("Supplement: ").append(this.supplements.size()).append(System.lineSeparator());
        stringBuilder.append("Energy: ").append(sumEnergy()).append(System.lineSeparator());
        return stringBuilder.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}
