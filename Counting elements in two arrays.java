// Question: Counting elements in two arrays (Medium)

// You are given two unsorted arrays a[] and b[]. Both arrays may contain duplicate elements. For each element in a[], your task is to count how many elements in b[] are less than or equal to that element.

// Examples:

// Input: a[] = [4, 8, 7, 5, 1], b[] = [4, 48, 3, 0, 1, 1, 5]
// Output: [5, 6, 6, 6, 3]
// Explanation: 
// For a[0] = 4, there are 5 elements in b (4, 3, 0, 1, 1) that are ≤ 4.
// For a[1] = 8 and a[2] = 7, there are 6 elements in b that are ≤ 8 and ≤ 7.
// For a[3] = 5, there are 6 elements in b that are ≤ 5.
// For a[4] = 1, there are 3 elements in b (0, 1, 1) that are ≤ 1.


// Input: a[] = [10, 20], b[] = [30, 40, 50]
// Output: [0, 0]
// Explanation: 
// For a[0] = 10 and a[1] = 20, there are no elements in b that are less than or equal to 10 or 20. Hence, the output is [0, 0].


// Constraints:
// 1 ≤ a.size(), b.size() ≤ 10^5
// 0 ≤ a[i], b[j] ≤ 10^5

// Expected Complexities
// Time Complexity: O(n + m + max(b[i]))
// Auxiliary Space: O(max(b[i]))


// Company Tags-> Amazon

// Topic Tags-> Arrays, Searching, Binary Search, Data Structures, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        int n = a.length;                              // number of elements in a
        int m = b.length;                              // number of elements in b
        ArrayList<Integer> result = new ArrayList<>(); // answer list

        int maxA = 0;

        for (int val : a) {
            if (val > maxA) {
                maxA = val;                          // find the maximum value in a
            }
        }

        int[] freq = new int[maxA + 1];              // freq[i] = count of i in b (if i <= maxA)

        // Build frequency array for b[]
        for (int i = 0; i < m; i++) {
            if (b[i] <= maxA) {
                freq[b[i]]++;                        // increment count of b[i]
            }
        }

        // Convert freq[] into prefix sum array so freq[i] = count of elements ≤ i
        for (int i = 1; i <= maxA; i++) {
            freq[i] += freq[i - 1];
        }

        // For each element in a, the answer is freq[a[i]] (number of b elements ≤ a[i])
        for (int i = 0; i < n; i++) {
            result.add(freq[a[i]]);
        }

        return result;
    }
}