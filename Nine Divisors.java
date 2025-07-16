// Question: Nine Divisors (Medium)

// Given a positive integer n, you need to count the numbers less than or equal to n having exactly 9 divisors.

// Examples :

// Input: n = 100
// Output: 2
// Explanation: Numbers which have exactly 9 divisors are 36 and 100.


// Input: n = 200
// Output: 3
// Explanation: Numbers which have exactly 9 divisors are 36, 100, 196. 


// Constraints:
// 1 ≤ n ≤ 10^9

// Expected Complexities
// Time Complexity: O(sqrt(n) * log(log(sqrt(n))))
// Auxiliary Space: O(sqrt(n))


// Topic Tags-> Searching, Prime Number, sieve, Binary Search, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    public static int countNumbers(int n) {
       int c = 0;
        int limit = (int)Math.sqrt(n);

        int[] prime = new int[limit + 1];
        for (int i = 1; i <= limit; i++)  prime[i] = i;

        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= limit; j += i)
                    if (prime[j] == j)
                        prime[j] = i;
            }
        }

        for (int i = 2; i <= limit; i++) {
            int p = prime[i];
            int q = prime[i / prime[i]];

            if (p * q == i && q != 1 && p != q) {
                c += 1;
            }

            else if (prime[i] == i && Math.pow(i, 8) <= n) {
                c += 1;
            }
        }

        return c;
    }
}