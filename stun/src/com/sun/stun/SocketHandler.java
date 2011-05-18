/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.stun;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author damirkusar
 */
public class SocketHandler {

    private static InetAddress publicIP = null;
    private static int publicPort = -29;
    private static InetAddress localIP = null;
    private static int localPort = -29;
    private static InetAddress sdpIP = null;
    private static int sdpPort = -29;
    private static InetAddress wanIP = null;
    private static int wanPort = -29;

    public static void setPublicSocket(InetAddress ip, int port) {
        String[] ipA = ip.toString().split("/");
        String ip1 = ipA[0];
        publicIP = ip;
        publicPort = port;
    }

    public static void setSdpSocket(InetAddress ip, int port) {
        String[] ipA = ip.toString().split("/");
        String ip1 = ipA[0];
        sdpIP = ip;
        sdpPort = port;
    }

    public static void setLocalSocket(InetAddress ip, int port) {
        String[] ipA = ip.toString().split("/");
        String ip1 = ipA[0];
        localIP = ip;
        localPort = port;
    }
    
    public static void setWanSocket(InetAddress ip, int port) {
        String[] ipA = ip.toString().split("/");
        String ip1 = ipA[0];
        wanIP = ip;
        wanPort = port;
    }

    public static InetSocketAddress getSenderAddressFromAString(String address) {
        String addr = address.toString();
        String sock = addr.split("@").toString();
        String[] sockSplit = addr.split(":");

        String inetAddr = sockSplit[0];
        int inetPort = Integer.valueOf(sockSplit[1]);

        InetSocketAddress socket = new InetSocketAddress(inetAddr, inetPort);


        return socket;
    }

    public static InetAddress getLocalIP() {
        return localIP;
    }

    public static int getLocalPort() {
        return localPort;
    }

    public static InetAddress getPublicIP() {
        return publicIP;
    }

    public static int getPublicPort() {
        return publicPort;
    }

    public static InetAddress getSdpIP() {
        return sdpIP;
    }

    public static int getSdpPort() {
        return sdpPort;
    }

    public static InetAddress getWanIP() {
        return wanIP;
    }

    public static int getWanPort() {
        return wanPort;
    }
    
    
    

    public static InetAddress findWanIP() {
        try {

            java.net.URL url = new java.net.URL(
                    "http://whatismyip.com/automation/n09230945.asp");

            java.net.HttpURLConnection con = (HttpURLConnection) url.openConnection();

            java.io.InputStream stream = con.getInputStream();

            java.io.InputStreamReader reader = new java.io.InputStreamReader(
                    stream);

            java.io.BufferedReader bReader = new java.io.BufferedReader(reader);
            
            
            wanIP = InetAddress.getByName(bReader.readLine());
            return wanIP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void test() throws SocketException {

        List<InetAddress> addresses = new LinkedList<InetAddress>();
        Enumeration<NetworkInterface> ifcs = NetworkInterface.getNetworkInterfaces();
        while (ifcs.hasMoreElements()) {
            NetworkInterface ifc = ifcs.nextElement();
            for (InterfaceAddress ifcAddr : ifc.getInterfaceAddresses()) {
                addresses.add(ifcAddr.getAddress());
                System.out.println("TESSSST: " + ifcAddr.getAddress());
            }
        }
    }
}
