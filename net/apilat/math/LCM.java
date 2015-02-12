package net.apilat.math;

public class LCM {
    public static int lcm(int a, int b){
        return a*(b/GCD.gcd(a, b));
    }

    public static long lcm(long a, long b){
        return a*(b/GCD.gcd(a, b));
    }
}
