package com.example.retrofit.proxy;

/**
 * Created by Jdqm on 2021/1/11
 */
public class UserProxy implements IUser{
    private IUser target;

    public UserProxy(IUser target) {
        this.target = target;
    }


    @Override
    public void hello() {
        System.out.println("pre Hello");
        target.hello();
        System.out.println("after Hello");
    }
}
