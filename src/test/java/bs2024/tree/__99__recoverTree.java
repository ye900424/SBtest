package bs2024.tree;

public class __99__recoverTree {
    public static void main(String[] args) {
        __99__recoverTree instance = new __99__recoverTree();
        TreeNode node1 =new TreeNode(1);
        TreeNode node2 =new TreeNode(2);
        TreeNode node3 =new TreeNode(3);
        TreeNode node4 =new TreeNode(4);
        node3.left = node1;
        node3.right = node4;
        node4.left = node2;

        instance.recoverTree(node3);
        TreeUtil.printFromLeft(node3);
    }

    TreeNode preNode = null;

    public void recoverTree(TreeNode root) {
        TreeNode[] swapArr = new TreeNode[2];
        // 找到下标
        findErrorNode(root,swapArr);

        // 交换
        TreeNode node1 = swapArr[0];
        TreeNode node2 = swapArr[1];
        if(null != node1 && null != node2){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

    }

    public void findErrorNode(TreeNode node,TreeNode[] swapArr){
        if(null == node){
            return;
        }

        findErrorNode(node.left,swapArr);

        if(null != preNode && preNode.val > node.val){
            swapArr[1] = node;
            if(null == swapArr[0]){
                swapArr[0] = preNode;
            }
        }
        preNode = node;

        findErrorNode(node.right,swapArr);
    }
}
