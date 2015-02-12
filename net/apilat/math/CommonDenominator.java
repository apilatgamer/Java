package net.apilat.math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonDenominator {
    public static int[] calculate(int a1, int a2, int b1, int b2){
        int c = LCM.lcm(a2, b2);

        a1 *= c/a2;
        a2 *= c/a2;

        b1 *= c/b2;
        b2 *= c/b2;

        return new int[]{a1, a2, b1, b2};
    }
}

class BringingFractionsToCommonDominator{
    public static void main(String[] args){
        System.out.println("***********************************************************************");
        System.out.println("************** Bringing Fraction To A Common Dominator ****************");
        System.out.println("***********************************************************************");

        int a1, a2, b1, b2, c[];

        System.out.print("\nWrite a counter of the first number: ");

        try {
            a1 = new Scanner(System.in).nextInt();

            if(a1 > 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        System.out.print("Write a denominator of the first number: ");

        try {
            a2 = new Scanner(System.in).nextInt();

            if(a2 > 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        System.out.print("Write a counter of the second number: ");

        try {
            b1 = new Scanner(System.in).nextInt();

            if(b1 > 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        System.out.print("Write a denominator of the second number: ");

        try {
            b2 = new Scanner(System.in).nextInt();

            if(b2 > 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        long start = System.currentTimeMillis();

        c = CommonDenominator.calculate(a1, a2, b1, b2);

        System.out.println();
        System.out.println(a1 + "/" + a2 + " = " +  c[0] + "/" + c[1]);
        System.out.println(b1 + "/" + b2 + " = " +  c[2] + "/" + c[3]);

          long stop = System.currentTimeMillis();

        System.out.print("\nTime: " + (stop - start) + " ms\n\n");
    }
}