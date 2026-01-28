package ascii.ui.factory;

import ascii.ui.elements.Button;
import ascii.ui.elements.TextField;
import ascii.ui.elements.Checkbox;
import ascii.ui.styleB.ButtonB;
import ascii.ui.styleB.TextFieldB;
import ascii.ui.styleB.CheckboxB;

/**
 * Factory for creating Style B UI elements (Classic/Simple style)
 */
public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}
