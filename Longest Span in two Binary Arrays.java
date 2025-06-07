// # Longest Span in two Binary Arrays (Medium)

// ### Question:
// Given two binary arrays, `a1[]` and `a2[]`. Find the length of longest common span `(i, j)` where `j >= i` such that:  
// a1[i] + a1[i+1] + ... + a1[j] = a2[i] + a2[i+1] + ... + a2[j]


// ### Examples:

// **Input:**  
// `a1[] = [0, 1, 0, 0, 0, 0]`  
// `a2[] = [1, 0, 1, 0, 0, 1]`  
// **Output:** `4`  
// **Explanation:** The longest span with same sum is from index `1` to `4` (0-based indexing).

// **Input:**  
// `a1[] = [0, 1, 0, 1, 1, 1, 1]`  
// `a2[] = [1, 1, 1, 1, 1, 0, 1]`  
// **Output:** `6`  
// **Explanation:** The longest span with same sum is from index `1` to `6` (0-based indexing).

// ### Constraints:
// - `1 <= a1.size() = a2.size() <= 10^6`
// - `0 <= a1[i], a2[i] <= 1`

// ---


class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        Map<Integer, Integer> map = new HashMap<>();  // diff -> first index
        int sum1 = 0, sum2 = 0, result = 0;

        for (int i = 0; i < n; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
            int diff = sum1 - sum2;

            if (diff == 0) {
                // from 0..i is balanced
                result = i + 1;
            } else if (map.containsKey(diff)) {
                // seen this diff before, subarray (map.get(diff)+1..i) is balanced
                result = Math.max(result, i - map.get(diff));
            } else {
                // first time seeing this diff
                map.put(diff, i);
            }
        }
        return result;
    }
}
