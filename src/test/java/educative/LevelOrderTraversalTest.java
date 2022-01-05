package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalTest {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // add the node to the current level
                currentLevel.add(currentNode.val);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    @Test
    void testTraverse(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverse(root);
        Assertions.assertEquals(3, result.size());
        Assertions.assertArrayEquals(new int[]{12}, result.get(0).stream().mapToInt(Integer::valueOf).toArray());
    }
}
