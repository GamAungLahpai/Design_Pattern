package organization;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class in the Composite pattern.
 * Represents a department that can contain other departments and employees.
 */
public class Department extends OrganizationComponent {

    private List<OrganizationComponent> components;

    public Department(String name) {
        super(name);
        this.components = new ArrayList<>();
    }

    /**
     * Adds a component (department or employee) to this department.
     */
    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    /**
     * Removes a component (department or employee) from this department.
     */
    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public double getTotalSalary() {
        double totalSalary = 0;
        for (OrganizationComponent component : components) {
            totalSalary += component.getTotalSalary();
        }
        return totalSalary;
    }

    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) + "<department name=\"" + name + "\">");

        for (OrganizationComponent component : components) {
            component.printXML(indent + 1);
        }

        System.out.println(getIndent(indent) + "</department>");
    }
}