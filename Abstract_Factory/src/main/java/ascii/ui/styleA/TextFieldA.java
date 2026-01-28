package ascii.ui.styleA;

import ascii.ui.elements.TextField;

/**
 * TextField implementation for Style A - uses single-line box borders (Modern/Bold)
 */
public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(text.length() + 2, 20);
        String content = text + " ".repeat(width - text.length() - 2);
        String border = "─".repeat(width);

        System.out.println("┌" + border + "┐");
        System.out.println("│ " + content + "│");
        System.out.println("└" + border + "┘");
    }
}
