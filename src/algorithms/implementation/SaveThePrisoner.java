package algorithms.implementation;

import java.util.Scanner;

/**
 * Created by brianzhao on 8/19/16.
 */
public class SaveThePrisoner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            long numPrisoners = scanner.nextInt();
            long numSweets = scanner.nextInt()-1;
            long prisonerId = scanner.nextInt()-1;


            //number of sweets remaining assuming each prisoner gets an equal amount of sweets
            long remainderNumSweets = numSweets % numPrisoners;

            long supposedDeadPrisoner = (remainderNumSweets + prisonerId) % numPrisoners;

            long deadPrisonerNumber = supposedDeadPrisoner + 1;
            System.out.println(deadPrisonerNumber);

        }
    }
}
