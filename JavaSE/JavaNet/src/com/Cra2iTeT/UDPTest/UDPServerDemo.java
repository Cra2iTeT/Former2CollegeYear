package com.Cra2iTeT.UDPTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(8080);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);

        socket.receive(packet);

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}