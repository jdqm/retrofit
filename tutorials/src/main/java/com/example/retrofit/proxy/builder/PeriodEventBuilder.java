package com.example.retrofit.proxy.builder;

/**
 * Created by Jdqm on 2021/1/12
 */
public class PeriodEventBuilder extends Builder<PeriodEventBuilder> {

    private int duration;

    public PeriodEventBuilder duration(int second) {
        this.duration = second;
        return this;
    }

    @Override
    public Event build() {
        return new PeriodEvent();
    }
}
