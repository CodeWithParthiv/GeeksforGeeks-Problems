// Question: Count Unique Vowel Strings (Medium)

// You are given a lowercase string s, determine the total number of distinct strings that can be formed using the following rules:

// Identify all unique vowels (a, e, i, o, u) present in the string.
// For each distinct vowel, choose exactly one of its occurrences from s. If a vowel appears multiple times, each occurrence represents a unique selection choice.
// Generate all possible permutations of the selected vowels. Each unique arrangement counts as a distinct string.
// Return the total number of such distinct strings.

// Examples:

// Input: s = "aeiou"
// Output: 120
// Explanation: Each vowel appears once, so the number of different strings can form is 5! = 120.


// Input: s = "ae"
// Output: 2
// Explanation: Pick a and e, make all orders → "ae", "ea".


// Input: s = "aacidf"
// Output: 4 
// Explanation: Vowels in s are 'a' and 'i', Pick each 'a' once with a single 'i', make all orders → "ai", "ia", "ai", "ia".


// Constraints:
// 1 ≤ s.size() ≤ 100

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)


// Topic Tags-> Strings, Combinatorial, Mathematical

// -------------------------------------------------------- SOLUTION --------------------------------------------------------


class Solution {
    public int vowelCount(String s) {
       int[] freq = new int[5]; 
        
        for (char ch : s.toCharArray()) {
            if (ch == 'a') freq[0]++;
            else if (ch == 'e') freq[1]++;
            else if (ch == 'i') freq[2]++;
            else if (ch == 'o') freq[3]++;
            else if (ch == 'u') freq[4]++;
        }

        int count = 0;
        int ways = 1;

        for (int f : freq) {
            if (f > 0) {
                count++;      
                ways *= f;    
            }
        }
        
        if (count == 0) return 0;

        return ways * factorial(count);
    }

    static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
  
}