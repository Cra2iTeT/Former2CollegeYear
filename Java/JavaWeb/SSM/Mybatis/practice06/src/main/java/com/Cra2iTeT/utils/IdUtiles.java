package com.Cra2iTeT.utils;

import java.util.UUID;

@SuppressWarnings("all")
public class IdUtiles {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}