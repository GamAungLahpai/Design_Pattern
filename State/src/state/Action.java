package state;

public enum Action {
    TRAIN("Train"),
    MEDITATE("Meditate"),
    FIGHT("Fight"),
    QUIT("Quit");

    private final String label;

    Action(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
