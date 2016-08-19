package algorithms.implementation;

import java.util.Scanner;

/**
 * Created by brianzhao on 8/19/16.
 */
public class StrangeCounter {

    public static long counter(long input) {
        int iteration = 0;
        long currentLong = 3;
        while (input > currentLong) {
            input -= currentLong;
            iteration++;
            currentLong = (long) (3 * Math.pow(2, iteration));
        }
        long total = currentLong + 1;
        return total - input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        System.out.println(counter(t));
    }
}
