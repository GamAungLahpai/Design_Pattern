package ascii.ui.factory;

import ascii.ui.elements.Button;
import ascii.ui.elements.TextField;
import ascii.ui.elements.Checkbox;

/**
 * Abstract Factory that declares creation methods for each UI element type.
 * Each concrete factory will create elements of a consistent style.
 */
public abstract class UIFactory {
    /**
     * Creates a Button with the specified text
     */
    public abstract Button createButton(String text);

    /**
     * Creates a TextField with the specified text
     */
    public abstract TextField createTextField(String text);

    /**
     * Creates a Checkbox with the specified text
     */
    public abstract Checkbox createCheckbox(String text);
}
