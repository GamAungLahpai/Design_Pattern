package state;

import java.util.List;

public class IntermediateState extends AbstractState {
    @Override
    public String getName() {
        return "Intermediate";
    }

    @Override
    public List<Action> getAvailableActions() {
        return List.of(Action.TRAIN, Action.MEDITATE);
    }

    @Override
    public void train(GameCharacter character) {
        character.addExperience(GameRules.TRAIN_EXP);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.addHealth(GameRules.MEDITATE_HEALTH);
    }
}
