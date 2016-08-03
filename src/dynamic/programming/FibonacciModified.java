package dynamic.programming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by brianzhao on 8/2/16.
 */
public class FibonacciModified {

    private int t1;
    private int t2;
    private Map<Integer, BigInteger> memo = new HashMap<>();

    public FibonacciModified(int t1, int t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public BigInteger solve(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 1) {
            return new BigInteger(String.valueOf(t1));
        }
        if (n == 2) {
            return new BigInteger(String.valueOf(t2));
        }
        BigInteger previous = solve(n - 1);
        BigInteger result = solve(n - 2).add(previous.multiply(previous));
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        int n = scanner.nextInt();
        FibonacciModified fibonacciModified = new FibonacciModified(t1, t2);
        System.out.println(fibonacciModified.solve(n));
    }


}
