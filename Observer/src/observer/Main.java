package observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation(-10, 40);
        station.setDaemon(true);

        WeatherObserver phoneApp  = new PhoneAppObserver("Alice");
        WeatherObserver billboard = new BillboardObserver("City Center");
        WeatherObserver dashboard = new CarDashboardObserver();

        station.registerObserver(phoneApp);
        station.registerObserver(billboard);
        station.registerObserver(dashboard);

        station.start();

        sleepSeconds(12);

        station.removeObserver(billboard);
        System.out.println("\n>>> Billboard removed from notifications.\n");

        sleepSeconds(12);

        System.out.println("=== Simulation ended ===");
    }

    private static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}