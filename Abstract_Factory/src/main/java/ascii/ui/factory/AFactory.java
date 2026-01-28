package ascii.ui.factory;

import ascii.ui.elements.Button;
import ascii.ui.elements.TextField;
import ascii.ui.elements.Checkbox;
import ascii.ui.styleA.ButtonA;
import ascii.ui.styleA.TextFieldA;
import ascii.ui.styleA.CheckboxA;
/**
 * Factory for creating Style A UI elements (Modern/Bold style)
 */
public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }
    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }
    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}
