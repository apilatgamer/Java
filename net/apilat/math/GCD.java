package net.apilat.math;

public class GCD {
    public static int gcd(int a, int b){
        int c;

        while(b != 0){
            c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    public static long gcd(long a, long b){
        long c;

        while(b != 0){
            c = a % b;
            a = b;
            b = c;
        }

        return a;
    }
}
