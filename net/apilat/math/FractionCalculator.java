package net.apilat.math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FractionCalculator {
    public static int[][] add(int a1, int a2, int b1, int b2){
        int[][] tab = new int[2][4];

        a1 = CommonDenominator.calculate(a1, a2, b1, b2)[0];
        a2 = CommonDenominator.calculate(a1, a2, b1, b2)[1];
        b1 = CommonDenominator.calculate(a1, a2, b1, b2)[2];
        b2 = CommonDenominator.calculate(a1, a2, b1, b2)[3];

        tab[0][0] = a1;
        tab[0][1] = a2;
        tab[0][2] = b1;
        tab[0][3] = b2;

        tab[1][0] = a1 + b1;
        tab[1][1] = a2;

        return tab;
    }

    public static int[][] subtract(int a1, int a2, int b1, int b2){
        int[][] tab = new int[2][4];

        a1 = CommonDenominator.calculate(a1, a2, b1, b2)[0];
        a2 = CommonDenominator.calculate(a1, a2, b1, b2)[1];
        b1 = CommonDenominator.calculate(a1, a2, b1, b2)[2];
        b2 = CommonDenominator.calculate(a1, a2, b1, b2)[3];

        tab[0][0] = a1;
        tab[0][1] = a2;
        tab[0][2] = b1;
        tab[0][3] = b2;

        tab[1][0] = a1 - b1;
        tab[1][1] = a2;

        return tab;
    }

    public static int[][] multiply(int a1, int a2, int b1, int b2){
        int[][] tab = new int[2][4];
        int c;

        c = GCD.gcd(a1, a2);

        a1 /= c;
        a2 /= c;

        c = GCD.gcd(b1, b2);

        b1 /= c;
        b2 /= c;

        c = GCD.gcd(a1, b2);

        a1 /= c;
        b2 /= c;

        c = GCD.gcd(b1, a2);

        b1 /= c;
        a2 /= c;

        tab[0][0] = a1;
        tab[0][1] = a2;
        tab[0][2] = b1;
        tab[0][3] = b2;

        tab[1][0] = a1 * b1;
        tab[1][1] = a2 * b2;

        return tab;
    }

    public static int[][] divide(int a1, int a2, int b1, int b2){
        int[][] tab = new int[3][4];

        int[] invert = new int[]{b1, b2};

        b1 = invert[1];
        b2 = invert[0];

        tab[0][0] = a1;
        tab[0][1] = a2;
        tab[0][2] = b1;
        tab[0][3] = b2;

        int c;

        c = GCD.gcd(a1, a2);

        a1 /= c;
        a2 /= c;

        c = GCD.gcd(b1, b2);

        b1 /= c;
        b2 /= c;

        c = GCD.gcd(a1, b2);

        a1 /= c;
        b2 /= c;

        c = GCD.gcd(b1, a2);

        b1 /= c;
        a2 /= c;

        tab[1][0] = a1;
        tab[1][1] = a2;
        tab[1][2] = b1;
        tab[1][3] = b2;

        tab[2][0] = a1 * b1;
        tab[2][1] = a2 * b2;

        return tab;
    }

    public static String disableWholes (int a1, int a2){
        if(a1 % a2 == 0){
            return Integer.toString(a1/a2);
        }

        if(a1 > a2){
            return Integer.toString((a1 - a1 % a2) / a2) + " " + Integer.toString(a1 % a2) + "/" + a2;
        }

        return a1 + "/" + a2;
    }
}

class CalculatingFractions{
    public static void main(String[] args){
        System.out.println("***********************************************************************");
        System.out.println("*********************** Fractions Calculator **************************");
        System.out.println("***********************************************************************");

        int a1, a2, b1, b2, operation, tab[][];

        System.out.print("\nWrite a counter of the first number: ");

        try {
            a1 = new Scanner(System.in).nextInt();

            if(a1 >= 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        System.out.print("Write a denominator of the first number: ");

        try {
            a2 = new Scanner(System.in).nextInt();

            if(a2 >= 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        System.out.print("Write a counter of the second number: ");

        try {
            b1 = new Scanner(System.in).nextInt();

            if(b1 >= 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        System.out.print("Write a denominator of the second number: ");

        try {
            b2 = new Scanner(System.in).nextInt();

            if(b2 >= 46340)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than sqrt(2^31 - 1)\n");
            return;
        }

        System.out.println("\nSelect operation:\n1 - Add\n2 - Subtract\n3 - Multiply\n4 - Divide");

        try{
            operation = new Scanner(System.in).nextInt();

            if(operation < 0 || operation > 4)
                throw new InputMismatchException();
        } catch(InputMismatchException e){
            System.err.print("Wrong operation code!\n");
            return;
        }

        long start = System.currentTimeMillis();

        switch(operation){
            case 1:
                tab = FractionCalculator.add(a1, a2, b1, b2);
                System.out.println("\n" + a1 + "/" + a2 + " + " + b1 + "/" + b2 + " =");
                System.out.println(tab[0][0] + "/" + tab[0][1] + " + " + tab[0][2] + "/" + tab[0][3] + " =");
                System.out.println(tab[1][0] + "/" + tab[1][1]);
                System.out.println(FractionCalculator.disableWholes(tab[1][0], tab[1][1]));
                break;

            case 2:
                tab = FractionCalculator.subtract(a1, a2, b1, b2);
                System.out.println("\n" + a1 + "/" + a2 + " - " + b1 + "/" + b2 + " =");
                System.out.println(tab[0][0] + "/" + tab[0][1] + " - " + tab[0][2] + "/" + tab[0][3] + " =");
                System.out.println(tab[1][0] + "/" + tab[1][1]);
                System.out.println(FractionCalculator.disableWholes(tab[1][0], tab[1][1]));
                break;

            case 3:
                tab = FractionCalculator.multiply(a1, a2, b1, b2);
                System.out.println("\n" + a1 + "/" + a2 + " * " + b1 + "/" + b2 + " =");
                System.out.println(tab[0][0] + "/" + tab[0][1] + " * " + tab[0][2] + "/" + tab[0][3] + " =");
                System.out.println(tab[1][0] + "/" + tab[1][1]);
                System.out.println(FractionCalculator.disableWholes(tab[1][0], tab[1][1]));
                break;

            case 4:
                tab = FractionCalculator.divide(a1, a2, b1, b2);
                System.out.println("\n" + a1 + "/" + a2 + " / " + b1 + "/" + b2 + " =");
                System.out.println(tab[0][0] + "/" + tab[0][1] + " * " + tab[0][2] + "/" + tab[0][3] + " =");
                System.out.println(tab[1][0] + "/" + tab[1][1] + " * " + tab[1][2] + "/" + tab[1][3] + " =");
                System.out.println(tab[2][0] + "/" + tab[2][1]);
                System.out.println(FractionCalculator.disableWholes(tab[2][0], tab[2][1]));
                break;
        }

        long stop = System.currentTimeMillis();

        System.out.print("\nTime: " + (stop - start) + " ms\n\n");
    }
}
