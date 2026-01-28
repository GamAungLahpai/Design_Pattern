package ascii.ui.styleB;

import ascii.ui.elements.TextField;

/**
 * TextField implementation for Style B - uses simple plus/minus borders (Classic/Simple)
 */
public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(text.length() + 2, 20);
        String content = text + " ".repeat(width - text.length() - 2);
        String border = "-".repeat(width);

        System.out.println("+" + border + "+");
        System.out.println("| " + content + "|");
        System.out.println("+" + border + "+");
    }
}
