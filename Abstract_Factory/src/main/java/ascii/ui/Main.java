package ascii.ui;

import ascii.ui.elements.Button;
import ascii.ui.elements.TextField;
import ascii.ui.elements.Checkbox;
import ascii.ui.factory.UIFactory;
import ascii.ui.factory.AFactory;
import ascii.ui.factory.BFactory;

/**
 * Main application demonstrating the Abstract Factory pattern.
 * Creates UI elements using different factories and demonstrates dynamic text changes.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║   ABSTRACT FACTORY PATTERN: ASCII Art UI Elements Demo    ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // ====================================================================
        // PART 1: Create UI elements using Factory A (Modern/Bold style)
        // ====================================================================
        System.out.println(">>> Creating UI Elements with STYLE A (Modern/Bold) <<<\n");
        UIFactory factoryA = new AFactory();

        Button btnA = factoryA.createButton("Click Me");
        TextField txtA = factoryA.createTextField("Enter your name");
        Checkbox chkA = factoryA.createCheckbox("I agree to terms");

        System.out.println("Button A:");
        btnA.display();
        System.out.println("\nTextField A:");
        txtA.display();
        System.out.println("\nCheckbox A:");
        chkA.display();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // ====================================================================
        // PART 2: Create UI elements using Factory B (Classic/Simple style)
        // ====================================================================
        System.out.println(">>> Creating UI Elements with STYLE B (Classic/Simple) <<<\n");
        UIFactory factoryB = new BFactory();

        Button btnB = factoryB.createButton("Submit");
        TextField txtB = factoryB.createTextField("Password");
        Checkbox chkB = factoryB.createCheckbox("Remember me");

        System.out.println("Button B:");
        btnB.display();
        System.out.println("\nTextField B:");
        txtB.display();
        System.out.println("\nCheckbox B:");
        chkB.display();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // ====================================================================
        // PART 3: Demonstrate dynamic content change using setText()
        // ====================================================================
        System.out.println(">>> Demonstrating Dynamic Text Change (setText method) <<<\n");

        System.out.println("Original Button A:");
        btnA.display();

        System.out.println("\nChanging text to 'Download Now'...");
        btnA.setText("Download Now");

        System.out.println("\nUpdated Button A:");
        btnA.display();

        System.out.println("\n--- TextField B Example ---");
        System.out.println("Original TextField B:");
        txtB.display();

        System.out.println("\nChanging text to 'john.doe@email.com'...");
        txtB.setText("john.doe@email.com");

        System.out.println("\nUpdated TextField B:");
        txtB.display();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // ====================================================================
        // PART 4: Demonstrate factory selection at runtime
        // ====================================================================
        System.out.println(">>> Dynamic Factory Selection <<<\n");

        String userPreference = "modern"; // Could be "modern" or "classic"

        UIFactory selectedFactory;
        if (userPreference.equals("modern")) {
            selectedFactory = new AFactory();
            System.out.println("User selected: Modern Theme (Factory A)");
        } else {
            selectedFactory = new BFactory();
            System.out.println("User selected: Classic Theme (Factory B)");
        }

        System.out.println("\nCreating Login Form with selected theme:\n");

        TextField username = selectedFactory.createTextField("Username");
        TextField password = selectedFactory.createTextField("Password");
        Checkbox remember = selectedFactory.createCheckbox("Remember me");
        Button login = selectedFactory.createButton("Login");

        System.out.println("Username Field:");
        username.display();
        System.out.println("\nPassword Field:");
        password.display();
        System.out.println("\nRemember Option:");
        remember.display();
        System.out.println("\nLogin Button:");
        login.display();

        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                      Demo Complete!                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}
