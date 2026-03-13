package org.example.memento;

public interface IMemento {
    int[] getOptions();
    boolean isSelected();
    String getSavedAt();
    String getDisplayText();
}