package state;

import java.util.List;

public class MasterState extends AbstractState {
    @Override
    public String getName() {
        return "Master";
    }

    @Override
    public List<Action> getAvailableActions() {
        return List.of();
    }
}
