package algorithms.strings;

import java.util.Scanner;

/**
 * Created by brianzhao on 8/19/16.
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int wordCount = 1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
}
