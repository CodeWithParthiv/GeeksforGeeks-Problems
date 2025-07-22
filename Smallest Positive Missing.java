// Question: Smallest Positive Missing (Medium)

// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

// Note: Positive number starts from 1. The array can have negative integers too.

// Examples:

// Input: arr[] = [2, -3, 4, 1, 1, 7]
// Output: 3
// Explanation: Smallest positive missing number is 3.


// Input: arr[] = [5, 3, 2, 5, 1]
// Output: 4
// Explanation: Smallest positive missing number is 4.


// Input: arr[] = [-8, 0, -1, -4, -3]
// Output: 1
// Explanation: Smallest positive missing number is 1.


// Constraints:  
// 1 ≤ arr.size() ≤ 10^5
// -10^6 ≤ arr[i] ≤ 10^6

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)


// Company Tags-> Accolite, Amazon, Samsung, Snapdeal


// Topic Tags-> Arrays, Searching, Data Structures, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

      
        boolean[] vis = new boolean[n];
        
        for (int i = 0; i < n; i++) {
           if (arr[i] > 0 && arr[i] <= n)  vis[arr[i] - 1] = true;
        }

    
        for (int i = 1; i <= n; i++) {
            if (!vis[i - 1]) {
                return i;
            }
        }

        
        return n + 1;
    }
}