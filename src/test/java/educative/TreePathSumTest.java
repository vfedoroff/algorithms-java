package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreePathSumTest {

    public static boolean hasPath(TreeNode root, int sum) {
        if (root != null) {
            if (root.val == sum && root.left == null && root.right == null) {
                return true;
            }
            return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
        }
        return false;
    }

    @Test
    void testHasPath(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        Assertions.assertTrue(hasPath(root, 23));
        Assertions.assertFalse(hasPath(root, 16));
    }
}
