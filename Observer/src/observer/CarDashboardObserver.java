package observer;

public class CarDashboardObserver implements WeatherObserver {

    private int previousTemperature;
    private boolean firstUpdate = true;

    @Override
    public void update(int temperature) {
        if (firstUpdate) {
            System.out.println("[Car Dashboard] Outside temp: " + temperature + "C");
            firstUpdate = false;
        } else {
            String trend = temperature > previousTemperature ? "rising"
                    : temperature < previousTemperature ? "falling"
                    : "stable";
            System.out.println("[Car Dashboard] Outside temp: " + temperature + "C (Temperature is " + trend + ")");
        }
        previousTemperature = temperature;
    }
}