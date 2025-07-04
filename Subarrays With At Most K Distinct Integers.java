Question: Subarrays With At Most K Distinct Integers (Medium)

You are given an array arr[] of positive integers and an integer k, find the number of subarrays in arr[] where the count of distinct integers is at most k.

Note: A subarray is a contiguous part of an array.

Examples:

Input: arr[] = [1, 2, 2, 3], k = 2
Output: 9
Explanation: Subarrays with at most 2 distinct elements are: [1], [2], [2], [3], [1, 2], [2, 2], [2, 3], [1, 2, 2] and [2, 2, 3].


Input: arr[] = [1, 1, 1], k = 1
Output: 6
Explanation: Subarrays with at most 1 distinct element are: [1], [1], [1], [1, 1], [1, 1] and [1, 1, 1].


Input: arr[] = [1, 2, 1, 1, 3, 3, 4, 2, 1], k = 2
Output: 24
Explanation: There are 24 subarrays with at most 2 distinct elements.


Constraints:
1 ≤ arr.size() ≤ 2*10^4
1 ≤ k ≤ 2*10^4
1 ≤ arr[i] ≤ 10^9

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(k)

Topic Tags-> sliding-window, Arrays, Data Structures, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public int countAtMostK(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>(); // to store frequency of elements in current window

        int i      = 0;                             // left boundary of sliding window
        int j      = 0;                             // right boundary of sliding window
        int result = 0;                             // total number of valid subarrays

        while (j < n) {
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1); // include arr[j] in the window

            while (mp.size() > k) {                         // if distinct elements exceed k, shrink window from left
                mp.put(arr[i], mp.get(arr[i]) - 1);
                if (mp.get(arr[i]) == 0) {
                    mp.remove(arr[i]); // remove element with 0 frequency
                }
                i++;                   // move left pointer to right
            }

            result += (j - i + 1);   // count subarrays ending at j with at most k distinct elements
            j++;                     // expand window to the right
        }
        return result;
    }
}