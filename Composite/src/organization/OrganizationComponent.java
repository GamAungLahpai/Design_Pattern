package organization;

/**
 * Component abstract class for the Composite pattern.
 * Defines common operations for both Department (composite) and Employee (leaf).
 */
public abstract class OrganizationComponent {

    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the component.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the total salary of this component.
     * For Employee: returns the employee's salary.
     * For Department: returns the sum of all salaries in the department.
     */
    public abstract double getTotalSalary();

    /**
     * Prints the XML representation of this component.
     * @param indent the indentation level for formatting
     */
    public abstract void printXML(int indent);

    /**
     * Adds a component to this component.
     * Default implementation does nothing (for leaf nodes like Employee).
     * Overridden in Department to actually add components.
     */
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component");
    }

    /**
     * Removes a component from this component.
     * Default implementation does nothing (for leaf nodes like Employee).
     * Overridden in Department to actually remove components.
     */
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component");
    }

    /**
     * Helper method to generate indentation string.
     */
    protected String getIndent(int level) {
        return "  ".repeat(level);
    }
}