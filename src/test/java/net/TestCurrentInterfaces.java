package net;

import me.muawb.project.gui.components.CustomJPanel;
import me.muawb.project.net.ActiveInterfaces;
import org.junit.Test;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class TestCurrentInterfaces {

    private ActiveInterfaces interfaces;
    private Map<String, String> ipAddresses;
    private List<String> listNames;

    @Test
    public void testFindIp(){
        interfaces = new ActiveInterfaces();
        ipAddresses = interfaces.findIpAddress();

        System.out.println(ipAddresses);
    }

    @Test
    public void testFindNames(){
        CustomJPanel panel = null;
        panel = new CustomJPanel(new GridBagLayout(), new Color(0,0,0), 0,0,0,0);
        interfaces = new ActiveInterfaces();
        listNames = interfaces.findNames();

        System.out.println(listNames);
    }
}
