package state;

import java.util.List;

public class NoviceState extends AbstractState {
    @Override
    public String getName() {
        return "Novice";
    }

    @Override
    public List<Action> getAvailableActions() {
        return List.of(Action.TRAIN);
    }

    @Override
    public void train(GameCharacter character) {
        character.addExperience(GameRules.TRAIN_EXP);
    }
}
