package algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by brianzhao on 8/2/16.
 */
public class SuperReducedString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String potentialResult = reduce(input);
        System.out.println(potentialResult.length() == 0 ? "Empty String" : potentialResult);
    }

    public static String reduce(String input) {
        List<Character> charBuffer = new ArrayList<>(input.length());
        for (Character c : input.toCharArray()) {
            charBuffer.add(c);
            cleanList(charBuffer);
        }
        StringBuilder result = new StringBuilder();
        for (Character c : charBuffer) {
            result.append(c);
        }
        return result.toString();
    }

    public static void cleanList(List<Character> input) {
        while (input.size() >= 2) {
            if (input.get(input.size() - 1).equals(input.get(input.size() - 2))) {
                input.remove(input.size() - 1);
                input.remove(input.size() - 1);
            } else {
                break;
            }
        }
    }
}
