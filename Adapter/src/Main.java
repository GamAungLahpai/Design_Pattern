public class Main {
    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        // Set date
        date.setDay(10);
        date.setMonth(3);
        date.setYear(2026);

        System.out.println("Original Date: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());

        // Advance days
        date.advanceDays(5);

        System.out.println("After 5 days: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());
    }
}