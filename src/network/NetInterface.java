package network;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;

public class NetInterface {
    public static ArrayList<NetworkInterface> getInterfaces() {
        ArrayList<NetworkInterface> interfaces = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
            while (nifs.hasMoreElements()) {
                NetworkInterface nif = nifs.nextElement();
                interfaces.add(nif);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return interfaces;
    }
}
