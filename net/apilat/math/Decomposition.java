package net.apilat.math;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Decomposition {
    public static LinkedList<Integer> calculate(int n){
        int num = n;

        LinkedList<Integer> i = new LinkedList<Integer>();

        if(PrimeNumbers.isPrime(n) == 0 || PrimeNumbers.isPrime(n) == 1){
            i.add(-1);
        } else if(PrimeNumbers.isPrime(n) < 0){
            i.add(n);
            i.add(1);
        } else {
            i.add(PrimeNumbers.isPrime(n));
            num /= PrimeNumbers.isPrime(num);

            for(;;){
                if(PrimeNumbers.isPrime(num) < 0){
                    i.add(num);
                    break;
                }

                if(PrimeNumbers.isPrime(num) > 1){
                    i.add(PrimeNumbers.isPrime(num));
                    num /= PrimeNumbers.isPrime(num);
                }
            }
        }

        return i;
    }
}

class DecompositionOfNumbers{
    public static void main(String[] args){
        System.out.println("***********************************************************************");
        System.out.println("******************** Decomposition Of Numbers *************************");
        System.out.println("***********************************************************************");

        System.out.print("\nWrite a number: ");

        int i = 0;

        try {
            i = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than 2^31 - 1\n");
            return;
        }

        long start = System.currentTimeMillis();

        LinkedList<Integer> list = Decomposition.calculate(i);

        if(list.getFirst() == -1) {
            System.out.print("\nNumber " + i + " is 0 or 1.\n");
        } else {
            System.out.print(i + " = ");

            System.out.print(list.poll() + " ");

            while (list.size() > 0) {
                System.out.print("* " + list.poll() + " ");
            }


            System.out.println();
        }

        long stop = System.currentTimeMillis();
        System.out.print("\nTime: " + (stop - start) + " ms\n\n");
    }
}

class DecompositionOfNumbersForStudents {
    public static void main(String[] args) {
        System.out.println("***********************************************************************");
        System.out.println("******************** Decomposition Of Numbers *************************");
        System.out.println("***********************************************************************");

        System.out.print("\nWrite a number: ");

        int i = 0;

        try {
            i = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.err.print("You must write a NUMBER smaller than 2^31 - 1\n");
            return;
        }

        long start = System.currentTimeMillis();

        LinkedList<Integer> list = Decomposition.calculate(i);

        if (list.getFirst() == -1) {
            System.out.print("\nNumber " + i + " is 0 or 1.\n");
        } else {
            int length = Integer.toString(i).length(), sum = i, num;

            System.out.print("\n" + sum + "|");
            num = list.poll();
            System.out.print(num + "\n");
            sum /= num;

            while (list.size() > 0) {
                for(int j = 0; j < length - Integer.toString(sum).length(); j++){
                    System.out.print(" ");
                }
                System.out.print(sum + "|");
                num = list.poll();
                System.out.print(num + "\n");
                sum /= num;
            }

            for(int j = 0; j < length - Integer.toString(sum).length(); j++){
                System.out.print(" ");
            }
            System.out.print("1");

            System.out.println();
        }

        long stop = System.currentTimeMillis();
        System.out.print("\nTime: " + (stop - start) + " ms\n\n");
    }
}