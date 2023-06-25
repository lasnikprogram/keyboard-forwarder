package config;

import network.NetInterface;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

public class ConfigurationInitializer {
    private final ConfigurationHolder configurationHolder = new ConfigurationHolder();
    private final Scanner scanner = new Scanner(System.in);
    public ConfigurationInitializer() {
        configureNetInterface();
        configureINetAddress();
    }

    private void configureINetAddress() {
        NetworkInterface nif = configurationHolder.getNetworkInterface();
        Enumeration<InetAddress> nifAddresses = nif.getInetAddresses();
        List<InetAddress> headers = Collections.list(nifAddresses);

        for (Object add: headers) {
            System.out.println(add.toString());
        }
    }

    private void configureNetInterface() {
        ArrayList<NetworkInterface> networkInterfaces = NetInterface.getInterfaces();
        for(NetworkInterface networkInterface : networkInterfaces) {
            System.out.println(networkInterface.getName());
        }

        System.out.print("Please choose one of the interfaces: ");
        String chosenInterface = scanner.nextLine();

        try {
            NetworkInterface networkInterface = NetworkInterface.getByName(chosenInterface);
            if (networkInterface == null) {
                System.out.println("No interface with such name found.\n");
                configureNetInterface();
            } else {
                configurationHolder.setNetworkInterface(networkInterface);
                System.out.println("Successfully set " + chosenInterface + " as the network interface");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    public ConfigurationHolder getHolder() {
        return configurationHolder;
    }
}
