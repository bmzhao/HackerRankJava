package algorithms.dynamic.programming;

//https://www.hackerrank.com/challenges/equal

import java.util.*;

/**
 * Created by brianzhao on 7/31/16.
 */
public class Equal {

    //Correct Solution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int numCoworkers = scanner.nextInt();
            List<Integer> startingChocos = new ArrayList<>();
            for (int j = 0; j < numCoworkers; j++) {
                startingChocos.add(scanner.nextInt());
            }
            System.out.println(numOperationsToEqualize(startingChocos));
        }
    }

    public static int numOperationsToEqualize(List<Integer> starting) {
        int min = Collections.min(starting);

        int upperRange = min >= 4 ? 4 : min;
        int currentTotalOps = Integer.MAX_VALUE;
        for (int i = 0; i <= upperRange; i++) {
            int totalOps = 0;
            int newMin = min - i;
            for (int chocos : starting) {
                totalOps += opsToZero(chocos - newMin);
            }
            if (totalOps < currentTotalOps) {
                currentTotalOps = totalOps;
            }
        }

        return currentTotalOps;
    }

    public static int opsToZero(int num) {
        int count = 0;
        count += num / 5;
        num = num % 5;
        count += num / 2;
        num = num % 2;
        count += num;
        return count;

    }

//Wrong Solution
//    public static int numOperationsToEqualize(List<Integer> starting) {
//        if (starting.size() == 1) {
//            return 0;
//        }
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(starting);
//        int totalOperations = 0;
//        int offset = 0; //offset to be added to all elements in the list
//
//        int firstMin = priorityQueue.poll();
//        while (!priorityQueue.isEmpty()) {
//            int secondMin = priorityQueue.poll();
//            int actualSecondMin = secondMin + offset;
//            if (actualSecondMin < firstMin) {
//                throw new RuntimeException();
//            }
//            int difference = actualSecondMin - firstMin;
//            offset += difference;
//            totalOperations += minOperationsForDifference(difference);
//            firstMin = actualSecondMin;
//        }
//        return totalOperations;
//    }
//
//
//    private static int minOperationsForDifference(int difference) {
//        int count = 0;
//        count += difference / 5;
//        difference = difference % 5;
//        count += difference / 2;
//        difference = difference % 2;
//        count += difference;
//        return count;
//    }
}
