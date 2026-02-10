package state;

import java.util.List;

public interface CharacterState {
    String getName();

    List<Action> getAvailableActions();

    void train(GameCharacter character);

    void meditate(GameCharacter character);

    void fight(GameCharacter character);
}
