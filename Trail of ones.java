// Question: Trail of ones (Medium)

// Given an integer n, the task is to count the number of binary strings of length n that contains at least one pair of consecutive 1's.
// Note: A binary string is a sequence made up of only 0's and 1's.

// Examples:

// Input: n = 2
// Output: 1
// Explanation: There are 4 strings of length 2, the strings are 00, 01, 10, and 11. Only the string 11 has consecutive 1's.


// Input: n = 3
// Output: 3
// Explanation: There are 8 strings of length 3, the strings are 000, 001, 010, 011, 100, 101, 110 and 111. The strings with consecutive 1's are 011, 110 and 111.


// Input: n = 5
// Output: 19
// Explanation: There are 19 strings having at least one pair of consecutive 1's.


// Constraints:
// 2 ≤ n ≤ 30

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)


// Company Tags-> Amazon

// Topic Tags-> Bit Magic, Data Structures, Dynamic Programming

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public int countConsec(int n) {
        if (n == 2) {               // Base: only "11" has consecutive 1’s when length = 2
            return 1;
        }

        int firstNum  = 0;          // Fib(i-2)
        int secondNum = 1;          // Fib(i-1)
        int thirdNum;               // Fib(i)
        int result = 1;             // Count of “bad” strings for length = 2

        for (int i = 3; i <= n; i++) {
            thirdNum  = firstNum + secondNum;     // Compute Fib(i)
            result    = result * 2 + thirdNum;    // Double previous + new “11” endings
            firstNum  = secondNum;                // Shift window
            secondNum = thirdNum;
        }
        return result;              // Final count for length = n
    }
}