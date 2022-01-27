package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessorTest {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);

                // break if we have found the key
                if (currentNode.val == key)
                    break;
            }
            return queue.peek();
        }
        return null;
    }

    @Test
    void testFindSuccessor(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = findSuccessor(root, 12);
        Assertions.assertEquals(7, result.val);
    }
}
