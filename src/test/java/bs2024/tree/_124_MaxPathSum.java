package bs2024.tree;

public class _124_MaxPathSum {
    public static void main(String[] args) {
        _124_MaxPathSum instance = new _124_MaxPathSum();
        TreeNode root = TreeUtil.create(3);
        TreeUtil.bfs(root);
        System.out.println(instance.maxPathSum(root));
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        tryGetMax(root);
        return max;
    }

    public int tryGetMax(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftMaxSum = tryGetMax(node.left);
        int rightMaxSum = tryGetMax(node.right);

        int tempSum = node.val + Math.max(0,leftMaxSum) + Math.max(0,rightMaxSum);
        max = Math.max(max,tempSum);

        return node.val + Math.max(0,Math.max(leftMaxSum,rightMaxSum));
    }
}
