package com.tuilu;

/**
 * Created by Administrator on 2015/12/29.
 */
public class Singleton {
    private volatile static Singleton singleton;
    public static Singleton getInstance() {
        // write your code here
        if(singleton==null)
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a==b);
    }
}
