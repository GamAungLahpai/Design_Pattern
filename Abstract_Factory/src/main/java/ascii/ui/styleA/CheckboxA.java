package ascii.ui.styleA;

import ascii.ui.elements.Checkbox;

/**
 * Checkbox implementation for Style A - uses Unicode checkbox symbol (Modern/Bold)
 */
public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("☐ " + text);
    }
}
