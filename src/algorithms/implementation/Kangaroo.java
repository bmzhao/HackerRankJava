package algorithms.implementation;

import java.util.Scanner;

/**
 * Created by brianzhao on 8/13/16.
 */
public class Kangaroo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();

        if (v1 != v2 && (x2 - x1) % (v1 - v2) == 0 && (x2 - x1) / (v1 - v2) > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
