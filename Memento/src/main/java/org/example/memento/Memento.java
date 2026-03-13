package org.example.memento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalDateTime savedAt;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone();
        this.isSelected = isSelected;
        this.savedAt = LocalDateTime.now();
        System.out.println("Memento created");
    }

    @Override
    public int[] getOptions() {
        return options.clone();
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getSavedAt() {
        return savedAt.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String getDisplayText() {
        return getSavedAt()
                + " | Colors: [" + options[0] + ", " + options[1] + ", " + options[2] + "]"
                + " | CheckBox: " + isSelected;
    }

    @Override
    public String toString() {
        return getDisplayText();
    }
}