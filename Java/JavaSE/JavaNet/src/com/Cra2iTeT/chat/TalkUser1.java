package com.Cra2iTeT.chat;

public class TalkUser1 {
    public static void main(String[] args) {
        new Thread(new TalkSent(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"User2")).start();
    }
}
