package organization;

/**
 * Main class to demonstrate the Composite design pattern
 * for organizational structure management.
 */
public class Main {

    public static void main(String[] args) {
        // Create the root organization (top-level department)
        Department organization = new Department("TechCorp");

        // Create departments
        Department engineering = new Department("Engineering");
        Department sales = new Department("Sales");
        Department development = new Department("Development");
        Department qa = new Department("QA");

        // Create employees
        Employee john = new Employee("John Smith", 75000);
        Employee jane = new Employee("Jane Doe", 80000);
        Employee bob = new Employee("Bob Johnson", 65000);
        Employee alice = new Employee("Alice Williams", 70000);
        Employee charlie = new Employee("Charlie Brown", 55000);
        Employee diana = new Employee("Diana Ross", 60000);

        // Build the organizational hierarchy
        engineering.add(development);
        engineering.add(qa);

        development.add(john);
        development.add(jane);

        qa.add(bob);
        qa.add(alice);

        sales.add(charlie);
        sales.add(diana);

        organization.add(engineering);
        organization.add(sales);

        // Demonstrate: Print total salary with a single method call
        System.out.println("=== Total Salary of Organization ===");
        System.out.println("Total Salary: $" + organization.getTotalSalary());
        System.out.println();

        // Demonstrate: Print organizational structure in XML format
        System.out.println("=== Organization Structure (XML) ===");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        organization.printXML(0);
        System.out.println();

        // Demonstrate: Adding and removing components at any time
        System.out.println("=== After Adding New Employee to Sales ===");
        Employee newEmployee = new Employee("Eve Miller", 58000);
        sales.add(newEmployee);
        System.out.println("New Total Salary: $" + organization.getTotalSalary());
        System.out.println();

        System.out.println("=== After Removing an Employee from QA ===");
        qa.remove(bob);
        System.out.println("New Total Salary: $" + organization.getTotalSalary());
        System.out.println();

        // Print final structure
        System.out.println("=== Final Organization Structure (XML) ===");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        organization.printXML(0);
    }
}