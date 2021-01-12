package com.example.retrofit.proxy.builder;

/**
 * Created by Jdqm on 2021/1/12
 */
public class FixedTimeEventBuilder extends Builder<FixedTimeEventBuilder>{
    private int second;
    private int minute;

    public FixedTimeEventBuilder second(int second) {
        this.second = second;
        return this;
    }

    public FixedTimeEventBuilder minute(int minute) {
        this.minute = minute;
        return this;
    }

    @Override
    public Event build() {
        return new FixedTimeEvent();
    }
}
