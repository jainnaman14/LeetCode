import java.util.*;

class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return build(
            inorder,
            postorder,
            0,
            inorder.length - 1
        );
    }

    private TreeNode build(
        int[] inorder,
        int[] postorder,
        int left,
        int right
    ) {
        if (left > right) {
            return null;
        }

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int rootPosition = inorderIndex.get(rootValue);

        root.right = build(
            inorder,
            postorder,
            rootPosition + 1,
            right
        );

        root.left = build(
            inorder,
            postorder,
            left,
            rootPosition - 1
        );

        return root;
    }
}