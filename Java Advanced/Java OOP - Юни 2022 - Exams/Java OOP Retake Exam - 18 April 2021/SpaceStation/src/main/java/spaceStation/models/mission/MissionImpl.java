package spaceStation.models.mission;

import spaceStation.core.ControllerImpl;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayDeque;
import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        ArrayDeque<String> items = new ArrayDeque<>(planet.getItems());
        for (Astronaut astronaut : astronauts) {
            while (!items.isEmpty()) {
                String tempItem = items.poll();
                astronaut.getBag().getItems().add(tempItem);
                planet.getItems().remove(tempItem);
                astronaut.breath();
                if (!astronaut.canBreath()) {
                    ControllerImpl.deadAstronauts++;
                    break;
                }
            }
        }
    }
}
