package ascii.ui.styleB;

import ascii.ui.elements.Checkbox;

/**
 * Checkbox implementation for Style B - uses square brackets (Classic/Simple)
 */
public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ ] " + text);
    }
}
