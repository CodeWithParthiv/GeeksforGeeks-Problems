// Question: Case-specific Sorting of Strings (Medium)

// Given a string s consisting of only uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

// Examples :

// Input: s = "GEekS"
// Output: EGekS
// Explanation: Sorted form of given string with the same case of character will result in output as EGekS.

// Input: s = "XWMSPQ"
// Output: MPQSWX
// Explanation: Since all characters are of the same case We can simply perform a sorting operation on the entire string.

// Constraints:
// 1 ≤ s.length() ≤ 10^5

// Expected Complexities
// Time Complexity: O(n log n)
// Auxiliary Space: O(n)

// Topic Tags
// Strings, Sorting, Data Structures, Algorithms

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    public static String caseSort(String s) {
        int n = s.length();

        List<Character> lower = new ArrayList<>();  // to hold all lowercase letters
        List<Character> upper = new ArrayList<>();  // to hold all uppercase letters

        // 1) Partition into lowercase and uppercase lists
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(ch);
            }
        }

        // 2) Sort both lists independently
        Collections.sort(lower);
        Collections.sort(upper);

        // 3) Reconstruct result by consuming from sorted lists
        StringBuilder result = new StringBuilder(n);
        int           l      = 0; // index for lowercase list
        int           u      = 0; // index for uppercase list

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(lower.get(l++));  // place next sorted lowercase
            } else {
                result.append(upper.get(u++));  // place next sorted uppercase
            }
        }

        return result.toString();
    }
}