package algorithms.implementation;

import java.util.*;

/**
 * Created by brianzhao on 8/13/16.
 */
public class NonDivisibleSubset {
    /**
     * key idea is to take each input number x, and convert it to x % k
     * we map from remainder value (x % k) to a counter of the number of elements
     * with that remainder
     *
     *
     * then, iterate through possible remainder values y (ranging from [0 to k-1])
     * and take the larger count of y and k-y, adding to maxsubset size
     *
     * special case of 0... if there exists >= 1 elem with remainder 0, then we can
     * add only one of those elements to the maximal subset (if we added any more
     * then we can sum two elements of remainder 0 to violate the condition)
     *
     * special case if k % 2 == 0... similarly when k is even, we can only include 1
     * element whose remainder is k / 2, if we added any more elements whose remainder is k /2,
     * then we can violate the given condition
     *
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Integer> modCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int currentNum = scanner.nextInt();
            int modded = currentNum % k;
            if (!modCount.containsKey(modded)) {
                modCount.put(modded, 0);
            }
            modCount.put(modded, modCount.get(modded) + 1);
        }
        int maxSubsetSize = 0;
        int stopPoint = (k % 2 == 0) ? k / 2 : k / 2 + 1;
        for (int i = 1; i < stopPoint; i++) {
            if (modCount.containsKey(i) && modCount.containsKey(k - i)) {
                maxSubsetSize += Math.max(modCount.get(i), modCount.get(k - i));
            } else {
                if (modCount.containsKey(i)) {
                    maxSubsetSize += modCount.get(i);
                }
                if (modCount.containsKey(k-i)) {
                    maxSubsetSize += modCount.get(k - i);
                }
            }
        }

        if (k % 2 == 0 && modCount.containsKey(k / 2)) {
            maxSubsetSize++;
        }

        if (modCount.containsKey(0)){
            maxSubsetSize++;
        }

        System.out.println(maxSubsetSize);
    }
}
