// Question: Next Greater Element in Circular Array (Medium)

// Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each element in the array.

// The next greater element of an element arr[i] is the first element that is greater than arr[i] when traversing circularly. If no such element exists, return -1 for that position.

// Circular Property:
// Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked at all elements once.

// Examples: 

// Input: arr[] = [1, 3, 2, 4]
// Output: [3, 4, 4, -1]
// Explanation:
// The next greater element for 1 is 3.
// The next greater element for 3 is 4.
// The next greater element for 2 is 4.
// The next greater element for 4 does not exist, so return -1.


// Input: arr[] = [0, 2, 3, 1, 1]
// Output: [2, 3, -1, 2, 2]
// Explanation:
// The next greater element for 0 is 2.
// The next greater element for 2 is 3.
// The next greater element for 3 does not exist, so return -1.
// The next greater element for 1 is 2 (from circular traversal).
// The next greater element for 1 is 2 (from circular traversal).


// Constraints:
// 1 ≤ arr.size() ≤ 10^5
// 0 ≤ arr[i] ≤ 10^6

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(n)


// Company Tags->Flipkart, Amazon, Microsoft

// Topic Tags-> Stack, Data Structures

// -------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;                        // Size of the array
        ArrayList<Integer> result = new ArrayList<>();

        for (int k = 0; k < n; k++) {              // Initialize result with -1s
            result.add(-1);
        }

        Stack<Integer> st = new Stack<>();         // Stack to store indices of waiting elements

        for (int i = 0; i < 2 * n; i++) {          // Traverse twice for circularity
            int idx = i % n;                       // Actual index in arr
            int num = arr[idx];                    // Current number

            // While current num is bigger than arr at the top index
            while (!st.isEmpty() && num > arr[st.peek()]) {
                result.set(st.pop(), num);         // Assign it as the next greater
            }

            if (i < n) {                           // Only push original indices on first pass
                st.push(idx);                      // Add index to stack
            }
        }
        return result;                             // Return filled results
    }
}