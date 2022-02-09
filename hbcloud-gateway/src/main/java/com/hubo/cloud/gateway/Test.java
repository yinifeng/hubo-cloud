package com.hubo.cloud.gateway;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(ZoneId.systemDefault());

        LocalDateTime dateTime = LocalDateTime.now();
        Instant instant1 = dateTime.toInstant(ZoneOffset.of("+8"));
        Instant instant = Instant.now();
        Date date = new Date(instant1.toEpochMilli());

        System.out.println(date);
    }
}
