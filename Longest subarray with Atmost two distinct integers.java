// Question: Longest subarray with Atmost two distinct integers (Medium)

// Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.

// Examples:

// Input: arr[] = [2, 1, 2]
// Output: 3
// Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.


// Input: arr[] = [3, 1, 2, 2, 2, 2]
// Output: 5
// Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5.


// Constraints:
// 1 ≤ arr.size() ≤ 10^5
// 1 ≤ arr[i] ≤ 10^5

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Topic Tags-> two-pointer-algorithm, Arrays, Data Structures, Algorithms, sliding-window

// --------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        int i      = 0;       // left boundary of window
        int j      = 0;       // right boundary of window
        int result = 0;       // best window size seen

        while (j < n) {
            // include arr[j] into the window
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            // if more than two distinct numbers, shrink from left
            while (map.size() > 2) {
                int count = map.get(arr[i]) - 1;
                if (count == 0) {
                    map.remove(arr[i]);     // remove key if freq is zero
                } else {
                    map.put(arr[i], count); // else update freq
                }
                i++;                        // move left boundary right
            }

            // window [i..j] is valid, update result
            result = Math.max(result, j - i + 1);
            j++;                           // expand window to the right
        }

        return result;
    }
}