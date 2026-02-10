package observer;

public class PhoneAppObserver implements WeatherObserver {

    private final String ownerName;

    public PhoneAppObserver(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public void update(int temperature) {
        String alert;
        if (temperature >= 35) {
            alert = "Extreme heat warning!";
        } else if (temperature <= -5) {
            alert = "Freezing cold warning!";
        } else {
            alert = "Weather update.";
        }
        System.out.println("[Phone App - " + ownerName + "] " + alert
                + " Current temperature: " + temperature + "C");
    }
}