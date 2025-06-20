// Question : Group Balls by Sequence (medium)

// You are given an array arr[] of positive integers, where each element arr[i] represents the number written on the i-th ball, and a positive integer k.
// Your task is to determine whether it is possible to rearrange all the balls into groups such that:


// Each group contains exactly k balls.
// The numbers in each group are consecutive integers

// Examples:

// Input: arr[] = [10, 1, 2, 11], k = 2
// Output: true
// Explanation: The hand can be rearranged as [1, 2], [10, 11]. There are two groups of size 2. Each group has 2 consecutive cards.


// Input: arr[] = [7, 8, 9, 10, 11], k = 2
// Output: false
// Explanation: The hand cannot be rearranged into groups of 2, since there are 5 cards, and 5 cards cannot be divided into groups of 2.


// Constraints:
// 1 ≤ arr.size() ≤ 10^6
// 0 ≤ arr[i] ≤ 10^5
// 1 ≤ k ≤ 10^3

// Expected Complexities
// Time Complexity: O(n log n)
// Auxiliary Space: O(n)

// -------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    public boolean validgroup(int[] arr, int k) {
        int n = arr.length;                  // total number of balls

        Arrays.sort(arr);                    // bring consecutive numbers together

        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {              // already used in a previous group
                continue;
            }

            int curr  = arr[i];              // the next expected number in the group
            int count = 0;                   // how many balls have been added to the current group

            for (int j = i; j < n; j++) {
                if (arr[j] == curr) {        // found the next consecutive ball
                    curr++;                  // expect the next number in sequence
                    count++;                 // one more ball added to this group
                    arr[j] = -1;             // mark this ball as used
                }

                if (count == k) {            // the group is complete
                    break;
                }
            }

            if (count != k) {                // could not form a full group of size k
                return false;
            }
        }

        return true;                         // all balls successfully grouped
    }
}