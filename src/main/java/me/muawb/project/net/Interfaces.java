package me.muawb.project.net;

import me.muawb.project.gui.WorkWindow;
import me.muawb.project.gui.components.CustomJButton;
import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.gui.events.NetworkEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
import java.util.List;

public class Interfaces {

    private static final Logger log = LoggerFactory.getLogger(Interfaces.class);

    private List<String> names;
    private Map<String, String> mapa;
    private WorkWindow wrk;

    public List<String> showNetworkInterfaces(CustomJPanel panel){ ;
        names = new ArrayList<>();
        wrk = new WorkWindow();
        try {
            Enumeration<NetworkInterface> inet = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface i : Collections.list(inet)) {
                if (i.isUp()) {
                    log.debug("Interfaces: " + i.getName());
                    names.add(i.getName());
                    CustomJButton interfaces = new CustomJButton(i.getName(), new Color(255,102,102),
                            new Font("TimesRoman", Font.BOLD, 10), 60, 26);
                    interfaces.build();
                    interfaces.addActionListener(new NetworkEvent(wrk.getFrame(), interfaces, i));
                    panel.add(interfaces);
                }
            }
        } catch (SocketException e){
            e.printStackTrace();
        }
        return names;
    }


    public Map<String, String> getInterfaces(){
        mapa = new HashMap<>();
        try {
            Enumeration<NetworkInterface> inet = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface i : Collections.list(inet)) {
                Enumeration<InetAddress> addr = i.getInetAddresses();
                for (InetAddress address : Collections.list(addr)) {
                    if (i.isUp()) {
                        log.debug("Interfaces: " + i.getName());
                        log.debug("Ip: " + address.getHostAddress());
                        mapa.put(i.getName(), address.getHostAddress());
                        break;
                    }
                }
            }
        } catch (SocketException e){
            e.printStackTrace();
        }
        return mapa;
    }
}
