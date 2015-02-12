package net.apilat.math;

import java.util.Scanner;

public class Factorial {
    public static int calculate(int x) {
        if(x == 1){
            return 1;
        } else {
            return x*calculate(x-1);
        }
    }

    public static long calculate(long x) {
        if(x == 1){
            return 1;
        } else {
            return x*calculate(x-1);
        }
    }
}