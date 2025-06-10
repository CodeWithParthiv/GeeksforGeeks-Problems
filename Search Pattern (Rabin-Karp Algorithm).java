// Question: Search Pattern (Rabin-Karp Algorithm)(Medium)

// Given two strings:

// A text string in which you want to search.

// A pattern string that you are looking for within the text.

// Return all positions (1-based indexing) where the pattern occurs as a substring in the text. If the pattern does not occur, return an empty list.

// All characters in both strings are lowercase English letters (a to z).

// Examples:

// Input: text = "birthdayboy", pattern = "birth"
// Output: [1]
// Explanation: The string "birth" occurs at index 1 in text.

// Input: text = "geeksforgeeks", pattern = "geek"
// Output: [1, 9]
// Explanation: The string "geek" occurs twice in text, one starts are index 1 and the other at index 9.

// Constraints:
// 1<= text.size() <=5*10^5
// 1<= pattern.size() <= text.size()

// Expected Complexities
// Time Complexity: O(n + m)
// Auxiliary Space: O(1)

// Company Tags - Microsoft

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // Helper function to compare pattern with substring of text at index idx
    private boolean isMatch(String txt, String pat, int idx) {
        for (int i = 0; i < pat.length(); i++) {
            if (txt.charAt(idx + i) != pat.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    ArrayList<Integer> search(String pat, String txt) {
        int m = pat.length(); // Length of pattern
        int n = txt.length(); // Length of text

        int base = 26;        // Base for hash (26 lowercase letters)
        int mod  = 101;       // A prime modulus to avoid overflow and reduce collisions

        ArrayList<Integer> result = new ArrayList<>();
        int patHash = 0; // Hash value for pattern
        int txtHash = 0; // Rolling hash value for text
        int power   = 1; // Power of base (base^i)

        // Compute initial hash for pattern and first window of text
        for (int i = m - 1; i >= 0; i--) {
            int patVal = pat.charAt(i) - 'a' + 1;
            int txtVal = txt.charAt(i) - 'a' + 1;

            patHash = (patHash + patVal * power) % mod;
            txtHash = (txtHash + txtVal * power) % mod;
            power   = (power * base) % mod;
        }

        // Compare first window hash
        if (txtHash == patHash && isMatch(txt, pat, 0)) {
            result.add(1); // Store 1-based index
        }

        // Precompute highest power for sliding window (base^(m-1))
        int highestPower = 1;
        for (int i = 1; i < m; i++) {
            highestPower = (highestPower * base) % mod;
        }

        // Slide window across text
        for (int i = 1; i <= n - m; i++) {
            int leftVal = txt.charAt(i - 1) - 'a' + 1;

            // Remove leftmost character from hash
            txtHash = (txtHash - (leftVal * highestPower) % mod + mod) % mod;
            txtHash = (txtHash * base) % mod;

            // Add new character to hash
            int newVal = txt.charAt(i + m - 1) - 'a' + 1;
            txtHash = (txtHash + newVal) % mod;

            // If hashes match, verify with character comparison
            if (txtHash == patHash && isMatch(txt, pat, i)) {
                result.add(i + 1); // Store 1-based index
            }
        }

        return result;
    }
}