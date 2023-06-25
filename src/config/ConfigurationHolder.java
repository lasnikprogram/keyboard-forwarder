package config;

import java.net.NetworkInterface;

public class ConfigurationHolder {
    public NetworkInterface getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    private NetworkInterface networkInterface;
}
