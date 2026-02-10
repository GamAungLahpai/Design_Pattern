package observer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation extends Thread implements WeatherSubject {
    private final List<WeatherObserver> observers = new CopyOnWriteArrayList<>();
    private final Random random = new Random();
    private final int minTemp;
    private final int maxTemp;
    private int temperature;

    public WeatherStation(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.temperature = random.nextInt(maxTemp - minTemp + 1) + minTemp;
        System.out.println("Weather Station initialized. Starting temperature: " + temperature + "C");
    }

    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            updateTemperature();
            System.out.println("\n--- Temperature updated to: " + temperature + "C ---");
            notifyObservers();
            sleepRandomInterval();
        }
    }

    private void updateTemperature() {
        int delta = random.nextBoolean() ? 1 : -1;
        int next = temperature + delta;
        if (next > maxTemp) {
            temperature = maxTemp - 1;
        } else if (next < minTemp) {
            temperature = minTemp + 1;
        } else {
            temperature = next;
        }
    }

    private void sleepRandomInterval() {
        int seconds = random.nextInt(5) + 1;
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}