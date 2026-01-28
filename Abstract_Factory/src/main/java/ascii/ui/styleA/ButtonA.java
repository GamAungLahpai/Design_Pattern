package ascii.ui.styleA;

import ascii.ui.elements.Button;

/**
 * Button implementation for Style A - uses double-line borders (Modern/Bold)
 */
public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = text.length() + 4;
        String border = "═".repeat(width);
        String padding = " ".repeat((width - text.length()) / 2);

        System.out.println("╔" + border + "╗");
        System.out.println("║" + padding + text + padding + "║");
        System.out.println("╚" + border + "╝");
    }
}
