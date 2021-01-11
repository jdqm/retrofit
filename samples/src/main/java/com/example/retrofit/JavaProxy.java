package com.example.retrofit;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Created by Jdqm on 2020/7/24
 */
public class JavaProxy {
    public static void main(String[] args) {
        IUser user = new User();
        IUser iUser = (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("pre save");
                method.invoke(user, args);
                System.out.println("after save");
                return null;
            }
        });


        byte[] proxyClassFile = ProxyGenerator.generateProxyClass("$Proxy0", user.getClass().getInterfaces(), Modifier.FINAL);

        try {
            FileOutputStream out = new FileOutputStream(new File("$Proxy0.class"));
            out.write(proxyClassFile);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        iUser.save();

        System.out.println(iUser.getClass());
    }
}

interface IUser {
    void save();
}


class User implements IUser {

    @Override
    public void save() {
        System.out.println("save user info");
    }
}