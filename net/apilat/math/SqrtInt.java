package net.apilat.math;

public class SqrtInt {
    public static int calculate(int n){
        int x;

        for(x = 0; x < n; x++){
            if(x * x > n){
                x--;
                break;
            }
        }

        return x;
    }

    public static long calculate(long n){
        long x;

        for(x = 0; x < n; x++){
            if(x * x > n){
                x--;
                break;
            }
        }

        return x;
    }
}
