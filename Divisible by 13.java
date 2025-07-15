// Question: Divisible by 13 (Medium)

// Given a number represented as a string s (which may be very large), check whether it is divisible by 13 or not.

// Examples:

// Input : s = "2911285"
// Output : true
// Explanation: 2911285 / 13 = 223945, which is a whole number with no remainder.


// Input : s = "27"
// Output : false
// Explanation: 27 / 13 ≈ 2.0769..., which is not a whole number (there is a remainder).


// Constraints:
// 1 ≤  s.size()  ≤ 10^5

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)


// Topic Tags-> Mathematical

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public boolean divby13(String s) {
        int rem = 0;
        for (int i = 0; i < s.length(); i++) {
            rem = (rem * 10 + (s.charAt(i) - '0')) % 13;
        }
        return rem == 0;
    }
}