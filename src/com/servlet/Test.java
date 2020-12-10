package com.servlet;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) {
        String str = "com.servlet.MyServlet";
        try {
            Class clazz = Class.forName(str);
            Constructor cons = clazz.getConstructor();
            Object obj = cons.newInstance();
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
