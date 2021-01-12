package com.example.retrofit.proxy.builder;

/**
 * Created by Jdqm on 2021/1/12
 */
public class Main {
    public static void main(String[] args) {
        Event fixedTimeEvent = new FixedTimeEventBuilder()
                .delay(100)
                .minute(10)
                .build();

        Event periodEvent = new PeriodEventBuilder()
                .delay(100)
                .duration(1000)
                .build();

    }
}
