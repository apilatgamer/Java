package net.apilat.math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShorteningFraction {
    public static int[] calculate(int a1, int a2){
        while(GCD.gcd(a1, a2) != 1){
            int c = GCD.gcd(a1, a2);

            a1 /= c;
            a2 /= c;
        }

        return new int[]{a1, a2};
    }
}

class ShorteningFractions{
    public static void main(String[] args){
        System.out.println("***********************************************************************");
        System.out.println("********************** Shortening Fractions ***************************");
        System.out.println("***********************************************************************");

        int a1, a2, c[];

        System.out.print("\nWrite a counter: ");

        try {
            a1 = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than 2^31 - 1\n");
            return;
        }

        System.out.print("Write a denominator: ");

        try {
            a2 = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than 2^31 - 1\n");
            return;
        }

        long start = System.currentTimeMillis();

        c = ShorteningFraction.calculate(a1, a2);

        System.out.println();
        System.out.println(a1 + "/" + a2 + " = " +  c[0] + "/" + c[1]);

        long stop = System.currentTimeMillis();

        System.out.print("\nTime: " + (stop - start) + " ms\n\n");
    }
}
