package state;

import java.util.Collections;
import java.util.List;

public abstract class AbstractState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        unavailable(Action.TRAIN, character);
    }

    @Override
    public void meditate(GameCharacter character) {
        unavailable(Action.MEDITATE, character);
    }

    @Override
    public void fight(GameCharacter character) {
        unavailable(Action.FIGHT, character);
    }

    @Override
    public List<Action> getAvailableActions() {
        return Collections.emptyList();
    }

    protected void unavailable(Action action, GameCharacter character) {
        System.out.println(character.getName() + " cannot " + action.getLabel().toLowerCase() + " at the " + getName() + " level.");
    }
}
