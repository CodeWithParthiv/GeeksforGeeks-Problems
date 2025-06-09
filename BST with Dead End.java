// Question: BST with Dead End (medium)

// You are given a Binary Search Tree (BST) containing unique positive integers greater than 0.

// Your task is to determine whether the BST contains a dead end.

// Note: A dead end is a leaf node in the BST such that no new node can be inserted in the BST at or below this node while maintaining the BST property and the constraint that all node values must be > 0.

// Examples:
// Input: root[] = [8, 5, 9, 2, 7, N, N, 1]
// Output: true
// Explanation: Node 1 is a Dead End in the given BST.

// Input: root[] = [8, 7, 10, 2, N, 9, 13]
// Output: true
// Explanation: Node 9 is a Dead End in the given BST.

// Constraints:
// 1 ≤ number of nodes ≤ 3000
// 1 ≤ node->data ≤ 10^5

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(h)


// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // Helper DFS function to detect dead ends in BST
    private boolean dfs(Node root, int min, int max) {
        if (root == null) {
            return false; // base case: empty subtree cannot have dead end
        }

        // if it's a leaf node
        if (root.left == null && root.right == null) {
            // check if no number can be inserted at or below this leaf
            if (root.data - min == 1 && max - root.data == 1) {
                return true;  // dead end found
            } else {
                return false; // not a dead end
            }
        }

        // recursively check in left and right subtrees
        return dfs(root.left, min, root.data) ||
               dfs(root.right, root.data, max);
    }
    
    public boolean isDeadEnd(Node root) {
        // Start with min = 0 and max = Integer.MAX_VALUE for root
        return dfs(root, 0, Integer.MAX_VALUE);
    }
}