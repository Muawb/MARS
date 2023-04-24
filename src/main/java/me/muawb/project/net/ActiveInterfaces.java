package me.muawb.project.net;

import me.muawb.project.gui.WorkWindow;
import me.muawb.project.gui.components.CustomJPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
import java.util.List;

/**
 * Show current network interfaces.
 * Have a two methods for displays list a data the network interfaces.
 * Let search a names and a ip address activity the network interfaces.
 */

public class ActiveInterfaces implements me.muawb.project.net.NetworkInterface {

    //Create logging for class.
    private static final Logger log = LoggerFactory.getLogger(ActiveInterfaces.class);

    //List with names the network interfaces.
    private List<String> listNames;

    //Map with names the network interfaces.
    private Map<String, String> mapNames;

    //Main frame.
    private WorkWindow wrk;

    //Make do custom panel.
    private CustomJPanel panel;

    public ActiveInterfaces(){

    }

    /**
     * Search active a network interfaces, return list with a name the network interfaces.
     *
     * @return
     *      list a names the network interfaces.
     */

    @Override
    public List<String> findNames(){
        //Create a object.
        listNames = new ArrayList<>();
        wrk = new WorkWindow();
        try {
            //Iteration on the network interfaces.
            Enumeration<NetworkInterface> inet = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface i : Collections.list(inet)) {
                //If active, get data.
                //Else skip it.
                if (i.isUp()) {
                    log.debug("Interfaces: " + i.getName());
                    listNames.add(i.getName());
                }
            }
        } catch (SocketException e){
            e.printStackTrace();
        }
        //List data.
        return listNames;
    }


    /**
     * Search active the network interfaces,
     * then return name and ip address the network interface.
     *
     * @return
     *      ip address and name, which have map.
     */

    @Override
    public Map<String, String> findIpAddress(){
        //Create a object.
        mapNames = new HashMap<>();
        try {
            //Do iteration.
            Enumeration<NetworkInterface> inet = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface i : Collections.list(inet)) {
                //Add in iteration a data about ip address.
                Enumeration<InetAddress> addr = i.getInetAddresses();
                for (InetAddress address : Collections.list(addr)) {
                    //If network interfaces active, get data.
                    //Else skip it.
                    if (i.isUp()) {
                        log.debug("Interfaces: " + i.getName());
                        log.debug("Ip: " + address.getHostAddress());
                        mapNames.put(i.getName(), address.getHostAddress());
                        //break; - active for windows, no active for linux.
                    }
                }
            }
        } catch (SocketException e){
            e.printStackTrace();
        }
        //return map which have present key and value.
        return mapNames;
    }
}
