package org.example.memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;

    private List<IMemento> undoHistory;
    private List<IMemento> redoHistory;
    private List<IMemento> stateHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
        this.stateHistory = new ArrayList<>();

        // save initial state
        stateHistory.add(model.createMemento());
    }

    public void setOption(int optionNumber, int choice) {
        saveForUndo();
        redoHistory.clear();

        model.setOption(optionNumber, choice);
        stateHistory.add(model.createMemento());

        gui.refreshHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveForUndo();
        redoHistory.clear();

        model.setIsSelected(isSelected);
        stateHistory.add(model.createMemento());

        gui.refreshHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            System.out.println("Memento found in undo history");

            redoHistory.add(model.createMemento());

            IMemento previousState = undoHistory.remove(undoHistory.size() - 1);
            model.restoreState(previousState);

            gui.updateGui();
            gui.refreshHistory();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");

            undoHistory.add(model.createMemento());

            IMemento redoState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(redoState);

            gui.updateGui();
            gui.refreshHistory();
        }
    }

    public List<IMemento> getStateHistory() {
        return stateHistory;
    }

    public void restoreFromHistory(int index) {
        if (index >= 0 && index < stateHistory.size()) {
            saveForUndo();
            redoHistory.clear();

            IMemento selectedState = stateHistory.get(index);
            model.restoreState(selectedState);

            gui.updateGui();
            gui.refreshHistory();
        }
    }

    private void saveForUndo() {
        IMemento currentState = model.createMemento();
        undoHistory.add(currentState);
    }
}