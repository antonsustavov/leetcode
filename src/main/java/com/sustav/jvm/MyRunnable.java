package com.sustav.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("RUN");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if ("MyRunnable".equals(name)) {
                    try(InputStream stream = MyRunnable.class.getResourceAsStream("MyRunnable.class")) {
                        byte[] classData = stream.readAllBytes();
                        return defineClass("MyRunnable", classData, 0, classData.length);
                    } catch (IOException ex) {
                        throw new ClassNotFoundException();
                    }
                }
                return super.loadClass(name);
            }
        };

        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();

        Class<?> aClass = classLoader.loadClass("com.sustav.jvm.MyRunnable");
        Runnable myRunnable1 = aClass.asSubclass(Runnable.class).getConstructor().newInstance();
        myRunnable1.run();

        System.out.println(myRunnable);
        System.out.println(myRunnable.getClass().getClassLoader());
        System.out.println(myRunnable1);
        System.out.println(myRunnable1.getClass().getClassLoader());
    }
}
