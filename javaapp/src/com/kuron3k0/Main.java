package com.kuron3k0;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            //Class.forName("com.kuron3k0.TrainPrint");
            Class clazz = Class.forName("java.lang.Runtime");

            Runtime runtime= (Runtime)clazz.getMethod("getRuntime").invoke(clazz);

            clazz.getMethod("exec",String.class).invoke(runtime,"calc.exe");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
