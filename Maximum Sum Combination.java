// Question: Maximum Sum Combination (medium)

// You are given two integer arrays a[] and b[] of equal size. A sum combination is formed by adding one element from a[] and one from b[], using each index pair (i, j) at most once. Return the top k maximum sum combinations, sorted in non-increasing order.

// Examples:

// Input: a[] = [3, 2], b[] = [1, 4], k = 2
// Output: [7, 6]
// Explanation: Possible sums: 3 + 1 = 4, 3 + 4 = 7, 2 + 1 = 3, 2 + 4 = 6, Top 2 sums are 7 and 6.


// Input: a[] = [1, 4, 2, 3], b[] = [2, 5, 1, 6], k = 3
// Output: [10, 9, 9]
// Explanation: The top 3 maximum possible sums are : 4 + 6 = 10, 3 + 6 = 9, and 4 + 5 = 9


// Constraints:
// 1 ≤ a.size() = b.size() ≤ 10^5
// 1 ≤ k ≤ a.size()
// 1 ≤ a[i], b[i] ≤ 10^4

// Expected Complexities
// Time Complexity: O(n log n)
// Auxiliary Space: O(n)


// Topic Tags-> Arrays, Sorting, Heap, Data Structures, Algorithms

// --------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // helper to reverse a sorted array in-place
    private void reverse(int[] arr) {
        for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
            int tmp = arr[l]; arr[l] = arr[r]; arr[r] = tmp;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;

        // sort both arrays in descending order
        Arrays.sort(a); reverse(a);                   // O(n log n)
        Arrays.sort(b); reverse(b);                   // O(n log n)

        // max-heap storing int[]{sum, i, j}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y)->Integer.compare(y[0], x[0])
            );
        Set<String> st = new HashSet<>();             // visited "i#j"

        // seed with the largest pair (0,0)
        pq.offer(new int[]{ a[0] + b[0], 0, 0 });
        st.add("0#0");

        ArrayList<Integer> result = new ArrayList<>(k);

        while (result.size() < k) {
            int[] top = pq.poll();                    // pop current max
            int sum = top[0], i = top[1], j = top[2];
            result.add(sum);                          // record it

            // push neighbor (i, j+1)
            if (j + 1 < n) {
                String key1 = i + "#" + (j + 1);
                if (st.add(key1)) {
                    pq.offer(new int[]{ a[i] + b[j + 1], i, j + 1 });
                }
            }
            // push neighbor (i+1, j)
            if (i + 1 < n) {
                String key2 = (i + 1) + "#" + j;
                if (st.add(key2)) {
                    pq.offer(new int[]{ a[i + 1] + b[j], i + 1, j });
                }
            }
        }
        return result;  // top k sums
    }
}