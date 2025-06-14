// Question: Symmetric Tree (Medium)

// Given the root of a binary tree, check whether it is symmetric, i.e., whether the tree is a mirror image of itself.

// A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.

// Examples:
// Input: root[] = [1, 2, 2, 3, 4, 4, 3]
// Output: True
// Explanation: As the left and right half of the above tree is mirror image, tree is symmetric.

// Input: root[] = [1, 2, 2, N, 3, N, 3]
// Output: False
// Explanation:  As the left and right half of the above tree is not the mirror image, tree is not symmetric.

// Constraints:
// 1  ≤ number of nodes ≤ 2000

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(h)

// Company Tags - Amazon, Microsoft

// -------------------------------------------------------- SOLUTION --------------------------------------------------------

class Solution {
    // Helper function to check if two subtrees are mirror images
    public boolean isMirror(Node l, Node r) {
        // If both nodes are null, they are mirror images
        if (l == null && r == null) {
            return true;
        }

        // If one is null and the other is not, not mirror images
        if (l == null || r == null) {
            return false;
        }

        // Check if current nodes are equal and subtrees are mirror images
        if ((l.data == r.data) && isMirror(l.left, r.right) && isMirror(l.right, r.left)) {
            return true;
        }

        // Otherwise, not mirror images
        return false;
    }
    
    // Main function to check if the tree is symmetric
    public boolean isSymmetric(Node root) {
        // If tree is empty, it's not symmetric (based on this implementation)
        if (root == null) {
            return false;
        }

        // Check if left and right subtrees are mirror images
        return isMirror(root.left, root.right);
    }
}