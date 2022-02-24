package com.Cra2iTeT.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {

    DatagramSocket socket = null;

    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.msgFrom = msgFrom;
        this.port = port;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
                socket.receive(packet);

                byte[] data = packet.getData();
                String s = new String(data, 0, data.length);

                System.out.println(msgFrom+":"+s);

                if (s.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
