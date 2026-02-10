package observer;

public class BillboardObserver implements WeatherObserver {

    private final String location;

    public BillboardObserver(String location) {
        this.location = location;
    }

    @Override
    public void update(int temperature) {
        String advice;
        if (temperature >= 30) {
            advice = "Stay cool and drink water!";
        } else if (temperature >= 15) {
            advice = "Nice weather today, enjoy!";
        } else if (temperature >= 0) {
            advice = "Cool outside, wear a jacket!";
        } else {
            advice = "Freezing! Bundle up!";
        }
        System.out.println("[Billboard - " + location + "] " + temperature + "C | " + advice);
    }
}