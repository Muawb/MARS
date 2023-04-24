package me.muawb.project.net;

import java.util.List;
import java.util.Map;

/**
 * This interface determine what class which implements it can do.
 * Need what be determine work object which provide functional for job with
 * network.
 */

public interface NetworkInterface {

    /**
     * Find names is active a network interfaces.
     * @return
     *      list of names.
     */

    public List<String> findNames();

    /**
     * Find ip addresses is active network interfaces.
     * @return
     *      map of ip address and names.
     */

    public Map<String, String> findIpAddress();
}
