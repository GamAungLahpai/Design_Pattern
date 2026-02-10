package state;

import java.util.Objects;

public class GameCharacter {
    private final String name;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = Objects.requireNonNull(name, "name");
        this.experience = 0;
        this.health = GameRules.MAX_HEALTH;
        this.state = new NoviceState();
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public String getLevelName() {
        return state.getName();
    }

    public CharacterState getState() {
        return state;
    }

    public boolean isMaster() {
        return state instanceof MasterState;
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void addExperience(int amount) {
        if (amount <= 0) {
            return;
        }
        experience += amount;
        System.out.println(name + " gains " + amount + " exp.");
        checkForLevelUp();
    }

    public void addHealth(int amount) {
        if (amount == 0) {
            return;
        }
        int previous = health;
        health = Math.max(0, Math.min(GameRules.MAX_HEALTH, health + amount));
        int delta = health - previous;
        if (delta > 0) {
            System.out.println(name + " gains " + delta + " health.");
        } else if (delta < 0) {
            System.out.println(name + " loses " + (-delta) + " health.");
        }
    }

    void setState(CharacterState state) {
        this.state = state;
    }

    void checkForLevelUp() {
        if (state instanceof NoviceState && experience >= GameRules.NOVICE_TO_INTERMEDIATE_EXP) {
            setState(new IntermediateState());
            System.out.println(name + " advances to Intermediate.");
        } else if (state instanceof IntermediateState && experience >= GameRules.INTERMEDIATE_TO_EXPERT_EXP) {
            setState(new ExpertState());
            System.out.println(name + " advances to Expert.");
        } else if (state instanceof ExpertState && experience >= GameRules.EXPERT_TO_MASTER_EXP) {
            setState(new MasterState());
            System.out.println(name + " becomes a Master.");
        }
    }
}
