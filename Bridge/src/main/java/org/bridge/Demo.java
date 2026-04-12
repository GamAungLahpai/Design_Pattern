package org.bridge;

import org.bridge.device.Device;
import org.bridge.device.Radio;
import org.bridge.device.Tv;
import org.bridge.remote.AdvancedRemote;
import org.bridge.remote.BasicRemote;
import org.bridge.device.Projector;
import org.bridge.remote.GamingRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testGamingSetup();
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testGamingSetup() {
        System.out.println("Tests with Projector and GamingRemote.");
        Projector projector = new Projector();
        GamingRemote gamingRemote = new GamingRemote(projector);

        gamingRemote.power();
        gamingRemote.volumeUp();
        gamingRemote.nextInputSource();
        gamingRemote.lowLatencyMode();

        projector.printStatus();
    }
}