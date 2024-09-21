package bs2024.tree;

public class _114_Flatten {
    public static void main(String[] args) {
        _114_Flatten instance = new _114_Flatten();
        TreeNode root = TreeUtil.create(10);
        TreeUtil.bfs(root);
        System.out.println("——————————————");
        instance.flatten(root);
        TreeUtil.bfs(root);

    }

    public void flatten(TreeNode root) {
        moveLeftToRight(root);
    }

    public void moveLeftToRight(TreeNode node) {
        if (node == null) {
            return;
        }

        moveLeftToRight(node.left);
        moveLeftToRight(node.right);

        if (node.left != null) {
            TreeNode right = node.right;
            TreeNode cur = node.left;
            while (cur.right != null) {
                cur = cur.right;
            }

            node.right = node.left;
            cur.right = right;
            node.left = null;
        }
    }
}
