package ascii.ui.elements;
/**
 * Abstract base class for all UI elements.
 * Defines common behavior: display() and setText()
 */
public abstract class UIElement {
    protected String text;
    public UIElement(String text) {
        this.text = text;
    }
    /**
     * Changes the text content of the UI element
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * Gets the current text content
     */
    public String getText() {
        return this.text;
    }
    /**
     * Displays the UI element in ASCII art
     */
    public abstract void display();
}
