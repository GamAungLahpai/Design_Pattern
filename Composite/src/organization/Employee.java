package organization;

/**
 * Leaf class in the Composite pattern.
 * Represents an employee with a name and salary.
 */
public class Employee extends OrganizationComponent {

    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) +
                "<employee name=\"" + name + "\" salary=\"" + salary + "\"/>");
    }
}