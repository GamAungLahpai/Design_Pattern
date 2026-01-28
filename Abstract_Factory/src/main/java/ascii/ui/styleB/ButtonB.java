package ascii.ui.styleB;

import ascii.ui.elements.Button;

/**
 * Button implementation for Style B - uses asterisk borders (Classic/Simple)
 */
public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = text.length() + 4;
        String border = "*".repeat(width + 2);
        String padding = " ".repeat((width - text.length()) / 2);

        System.out.println(border);
        System.out.println("*" + padding + text + padding + "*");
        System.out.println(border);
    }
}
