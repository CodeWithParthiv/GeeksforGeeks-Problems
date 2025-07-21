// Question: Count the Coprimes (Hard)

// You are given an array arr[] of positive integers. Your task is to count the number of pairs (i, j) such that:


// 0 ≤ i < j ≤ n-1
// gcd(arr[i], arr[j]) = 1
// In other words, count the number of unordered pairs of indices (i, j) where the elements at those positions are co-prime.

// Examples:

// Input: arr[] = [1, 2, 3]
// Output: 3
// Explanation: (0,1), (0,2), (1,2) are the pair of indices where gcd(arr[i], arr[j]) = 1


// Input: arr[] = [4, 8, 3, 9]
// Output: 4
// Explanation: (0,2), (0,3), (1,2), (1,3) are the pair of indices where gcd(arr[i], arr[j]) = 1


// Constraints:
// 2 ≤ arr.size() ≤ 10^4
// 1 ≤ arr[i] ≤ 10^4

// Expected Complexities
// Time Complexity: O(n + M*log M), where M = max(arr[i])
// Auxiliary Space: O(M), where M = max(arr[i])


// Topic Tags-> number-theory, Mathematical, sieve, inclusion-exclusion, Algorithms


// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    
    static final int MAX = 10000;
    static int[] mobius = new int[MAX + 1];

    static void computeMobius() {
        Arrays.fill(mobius, 1);
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= MAX; j += i) {
                    mobius[j] *= -1;
                    isPrime[j] = false;
                }
                for (int j = i * i; j <= MAX; j += i * i) {
                    mobius[j] = 0;
                }
            }
        }
    }

     int cntCoprime(int[] arr) {
        computeMobius(); 

        int[] freq = new int[MAX + 1];
        for (int num : arr) {
            freq[num]++;
        }

     
        int[] divisibleCount = new int[MAX + 1];
        for (int d = 1; d <= MAX; d++) {
            for (int j = d; j <= MAX; j += d) {
                divisibleCount[d] += freq[j];
            }
        }

       
        long total = 0;
        for (int d = 1; d <= MAX; d++) {
            int count = divisibleCount[d];
            long pairs = (long) count * (count - 1) / 2;
            total += mobius[d] * pairs;
        }

        return (int) total;
    }

}
