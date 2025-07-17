// Question: Power of k in factorial of n (Medium)

// Given two positive integers n and k, determine the highest value of x such that kx divides n! (n factorial) completely (i.e., n % (kx) == 0).

// Examples :

// Input: n = 7, k = 2
// Output: 4
// Explanation: 7! = 5040, and 24 = 16 is the highest power of 2 that divides 5040.


// Input: n = 10, k = 9
// Output: 2
// Explanation: 10! = 3628800, and 9² = 81 is the highest power of 9 that divides 3628800.


// Constraints:
// 1 ≤ n ≤ 10^5
// 2 ≤ k ≤ 10^5

// Expected Complexities
// Time Complexity: O(sqrt(k) + m * log n), m = number of distinct prime factors in k
// Auxiliary Space: O(m), m = number of distinct prime factors in k


// Topic Tags-> number-theory, Mathematical, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    public int maxKPower(int n, int k) {
      Map<Integer, Integer> primeFactors = new HashMap<>();
        int num = k;
        for (int i = 2; i * i <= num; i++) {
            while (k % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            primeFactors.put(k, 1);
        }

        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int powerInK = entry.getValue();
            
            int count = 0;
            int tempN = n;

            while (tempN > 0) {
                count += tempN / prime;
                tempN /= prime;
            }

            result = Math.min(result, count / powerInK);
        }

        return result;
    }
}