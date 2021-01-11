package com.example.retrofit.proxy;

class User implements IUser {

    @Override
    public void hello() {
        System.out.println("Hello");
    }
}