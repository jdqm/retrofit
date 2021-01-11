package com.example.retrofit.proxy;

/**
 * Created by Jdqm on 2021/1/11
 */
public class StaticProxy {
    public static void main(String[] args) {
        IUser user = new User();
        UserProxy proxy = new UserProxy(user);
        proxy.hello();
    }
}
