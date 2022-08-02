package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayDeque;
import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        ArrayDeque<String> exhibits = new ArrayDeque<>(state.getExhibits());
        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && !exhibits.isEmpty()) {
                String tempExhibits = exhibits.poll();
                explorer.search();
                explorer.getSuitcase().getExhibits().add(tempExhibits);
                state.getExhibits().remove(tempExhibits);
            }
            if (exhibits.isEmpty()) break;
        }
    }
}
