// Question: Find the longest string (Medium)

// Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also present in the array words[]. 

// Note: If multiple strings have the same maximum length, return the lexicographically smallest one.

// Examples:

// Input: words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
// Output: pros
// Explanation: "pros" is the longest word with all prefixes ("p", "pr", "pro", "pros") present in the array words[].


// Input: words[] = ["ab", "a", "abc", "abd"]
// Output: abc
// Explanation: Both "abc" and "abd" has all the prefixes in words[]. Since, "abc" is lexicographically smaller than "abd", so the output is "abc".


// Constraints:
// 1 ≤ words.length() ≤ 10^3
// 1 ≤ words[i].length ≤ 10^3

// Expected Complexities
// Time Complexity: O(n * max(words[i].size()) )
// Auxiliary Space: O(n * max(words[i].size()) )


// Company Tags-> Flipkart


// Topic Tags-> Strings, BFS, Trie, Data Structures, Algorithms, Advanced Data Structure

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // Trie node definition
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private TrieNode root = new TrieNode();

    // Insert a word into the Trie
    private void insert(String word) {
        TrieNode crawler = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true; // mark end of this word
    }

    // Return true if all prefixes of word exist and are ends of words
    private boolean search(String word) {
        TrieNode crawler = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            crawler = crawler.children[index];
            if (crawler == null || !crawler.isEndOfWord) {
                return false; // missing prefix or prefix not a completed word
            }
        }
        return true;
    }
    
    public String longestString(String[] arr) {
        // build Trie
        for (String word : arr) {
            insert(word);
        }

        String result = "";
        // check each word
        for (String word : arr) {
            if (search(word)) {
                // choose longer or lexicographically smaller on tie
                if (word.length() > result.length() ||
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
}