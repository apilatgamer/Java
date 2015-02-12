package net.apilat.math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumbers {
    public static int isPrime(int n){
        int b = -1;

        if(n > 1) {
            if(n % 2 != 0) {
                if(n != 3) {
                    for (int i = 3; i <= SqrtInt.calculate(n); i += 2) {
                        if (n % i == 0) {
                            b = i;
                            break;
                        }
                    }
                } else {
                    b = -1;
                }
            } else {
                if(n != 2) {
                    b = 2;
                } else {
                    b = -1;
                }
            }
        } else if(n == 0 || n == 1) {
            b = n;
        } else {
            b = 0;
        }

        return b;
    }

    public static long isPrime(long n){
        long b = -1;

        if(n > 1) {
            if(n % 2 != 0) {
                if(n != 3) {
                    for (int i = 3; i <= SqrtInt.calculate(n); i += 2) {
                        if (n % i == 0) {
                            b = i;
                            break;
                        }
                    }
                } else {
                    b = -1;
                }
            } else {
                if(n != 2) {
                    b = 2;
                } else {
                    b = -1;
                }
            }
        } else if(n == 0 || n == 1) {
            b = n;
        } else {
            b = 0;
        }

        return b;
    }
}

class IsItPrimeNumber {
    public static void main(String[] args){
        System.out.println("***********************************************************************");
        System.out.println("********************** Is It Prime Number? ****************************");
        System.out.println("***********************************************************************");

        System.out.print("\nWrite a number: ");
        long i = 0;

        try {
            i = new Scanner(System.in).nextLong();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than 2^63 - 1\n");
            return;
        }

        long start = System.currentTimeMillis();

        System.out.print("\nNumber " + i + (PrimeNumbers.isPrime(i) == -1 ? " is prime number." : " isn't prime number.\n"));

        if(PrimeNumbers.isPrime(i) != -1)
            System.out.print(i + (PrimeNumbers.isPrime(i) < 2 ? (PrimeNumbers.isPrime(i) == 0 ? (" < 0") : ( PrimeNumbers.isPrime(i) == 0 ? (" == 0") : (" == 1")) ) : (" / " + PrimeNumbers.isPrime(i) + " = " +(i / PrimeNumbers.isPrime(i)))) + "\n");
        else
            System.out.println();

        long stop = System.currentTimeMillis();

        System.out.print("\nTime: " + (stop - start) + " ms\n\n");
    }
}
