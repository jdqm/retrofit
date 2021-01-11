package com.example.retrofit.proxy;

//import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        IUser user = new User();
        IUser proxy = (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("pre Hello");
                method.invoke(user, args);
                System.out.println("after Hello");
                return null;
            }
        });

        proxy.hello();

//        byte[] proxyClassFile = ProxyGenerator.generateProxyClass("$Proxy0", user.getClass().getInterfaces(), Modifier.PUBLIC | Modifier.FINAL);
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(new File("$Proxy0.class"));
//            out.write(proxyClassFile);
//            out.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }



        System.out.println(proxy.getClass());
    }
}