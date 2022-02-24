package com.Cra2iTeT.UDPTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        String msg = "Hello,Cra2iTeT";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;

        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);

        socket.send(packet);

        socket.close();
    }
}
