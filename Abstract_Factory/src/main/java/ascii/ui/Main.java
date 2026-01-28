package ascii.ui;

import ascii.ui.elements.Button;
import ascii.ui.elements.TextField;
import ascii.ui.elements.Checkbox;
import ascii.ui.factory.UIFactory;
import ascii.ui.factory.AFactory;
import ascii.ui.factory.BFactory;

public class Main {
    public static void main(String[] args) {
        // Create UI elements with Style A
        System.out.println("=== Style A (Simple Box) ===\n");
        UIFactory factoryA = new AFactory();

        Button buttonA = factoryA.createButton("Click Me");
        TextField textFieldA = factoryA.createTextField("Enter name");
        Checkbox checkboxA = factoryA.createCheckbox("I agree");

        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        // Create UI elements with Style B
        System.out.println("\n=== Style B (Double Line) ===\n");
        UIFactory factoryB = new BFactory();

        Button buttonB = factoryB.createButton("Submit");
        TextField textFieldB = factoryB.createTextField("Password");
        Checkbox checkboxB = factoryB.createCheckbox("Remember me");

        buttonB.display();
        textFieldB.display();
        checkboxB.display();

        // Demonstrate setText()
        System.out.println("\n=== Testing setText() ===\n");
        buttonA.setText("New Text");
        buttonA.display();
    }
}