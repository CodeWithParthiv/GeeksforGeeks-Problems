// Question: Exactly one swap (Medium)

// Given a string s, return the number of distinct strings that can be obtained by exactly one swap of two different indices (i < j).

// Examples:

// Input: s = "geek"
// Output: 6
// Explanation: After one swap, There are only 6 distinct strings possible.(i.e "egek","eegk","geek","geke","gkee" and "keeg") 

// Input: s = "aaaa"
// Output: 1
// Explanation: Only one distinct string is possible after one swap(i.e "aaaa")

// Constraints:
// 2 ≤ s.size() ≤ 10^4

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    int countStrings(String s) {
        int n = s.length();
        int[] mp = new int[26];         // frequency array
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += (i - mp[s.charAt(i) - 'a']);   // swaps with different chars seen so far
            mp[s.charAt(i) - 'a']++;                 // increment current char freq
        }

        for (int i = 0; i < 26; i++) {
            if (mp[i] > 1) {         // duplicate character found
                result++;            // one extra swap that results in same string
                break;
            }
        }

        return result;
    }
}