// Question: Police and Thieves (medium)

// Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
// Keep in mind the following conditions :

// Each policeman can catch only one thief.
// A policeman cannot catch a thief who is more than k units away from him.

// Examples:
// Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
// Output: 2
// Explanation: Maximum 2 thieves can be caught. First policeman catches first thief and second police man can catch either second or third thief.

// Input: arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2
// Output: 3
// Explanation: Maximum 3 thieves can be caught.

// Constraints:
// 1 ≤ arr.size() ≤ 10^5
// 1 ≤ k ≤ 1000
// arr[i] = 'P' or 'T'

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Company Tags -> Microsoft

// Topic Tags ->  Greedy, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public int catchThieves(char[] arr, int k) {
        int n     = arr.length;
        int i     = 0;    // pointer to scan for 'P'
        int j     = 0;    // pointer to scan for 'T'
        int count = 0;    // total thieves caught

        while (i < n && j < n) {
            // move i to the next policeman
            while (i < n && arr[i] != 'P') {
                i++;
            }
            // move j to the next thief
            while (j < n && arr[j] != 'T') {
                j++;
            }

            // if both pointers are valid and within k distance, catch!
            if (i < n && j < n && Math.abs(i - j) <= k) {
                count++;
                i++;
                j++;
            }
            // if thief is too far left, move thief pointer right
            else if (j < n && j < i) {
                j++;
            }
            // if policeman is too far left, move policeman pointer right
            else if (i < n && i < j) {
                i++;
            }
        }
        return count;
    }
}
