package summary.sieve_of_eratosthenes;

import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = scanner.nextInt();
        boolean prime = isPrime(inputNumber);

        System.out.println(String.format("number %d is %sprime", inputNumber, prime ? "" : "not "));

        scanner.close();
    }

    private static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        int base = 10;
        int maxExponent = (int) Math.log10(number) + 1;
        int maxSize = (int) Math.pow(base, maxExponent);

       boolean[] seiveOfEratosthenes = getSeiveOfEratosthenes(maxSize);

        return seiveOfEratosthenes[number];
    }

    private static boolean[] getSeiveOfEratosthenes(int numSize) {
        int arraySize = numSize + 1;
        boolean[] isPrime = new boolean[arraySize];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int num = 2; (num * num) <= arraySize; num++) {
            for (int multiplyNum = (num * num); multiplyNum <= arraySize; multiplyNum += num) {
                if (isPrime[multiplyNum]) {
                    isPrime[multiplyNum] = false;
                }
            }
        }

        return isPrime;
    }

}
