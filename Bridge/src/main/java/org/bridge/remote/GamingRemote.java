package org.bridge.remote;

import org.bridge.device.Device;

public class GamingRemote extends BasicRemote {

    public GamingRemote(Device device) {
        super(device);
    }
    public void nextInputSource() {
        System.out.println("GamingRemote: Switching input source");
        device.setChannel(device.getChannel() + 1);
    }
    public void lowLatencyMode() {
        System.out.println("GamingRemote: Activating low latency mode");
    }
}