package com.Cra2iTeT.chat;

public class TalkUser2 {
    public static void main(String[] args) {
        new Thread(new TalkSent(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"User1")).start();
    }
}
