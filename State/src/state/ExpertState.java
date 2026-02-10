package state;

import java.util.List;

public class ExpertState extends AbstractState {
    @Override
    public String getName() {
        return "Expert";
    }

    @Override
    public List<Action> getAvailableActions() {
        return List.of(Action.TRAIN, Action.MEDITATE, Action.FIGHT);
    }

    @Override
    public void train(GameCharacter character) {
        character.addExperience(GameRules.TRAIN_EXP);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.addHealth(GameRules.MEDITATE_HEALTH);
    }

    @Override
    public void fight(GameCharacter character) {
        character.addHealth(-GameRules.FIGHT_HEALTH_COST);
        character.addExperience(GameRules.FIGHT_EXP);
    }
}
