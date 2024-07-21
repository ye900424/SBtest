package bs2024.tree;


import java.util.ArrayList;
import java.util.List;

//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案
public class _95_generateTrees {
    public static void main(String[] args) {
        _95_generateTrees instance = new _95_generateTrees();
        List<TreeNode> nodeList = instance.generateTrees(3);

        TreeUtil.printFromMid(nodeList);
    }

    public List<TreeNode> generateTrees(int n) {
        return addChild(1,n);
    }

    public List<TreeNode> addChild(int start,int end){
        List<TreeNode> nodeList = new ArrayList<>();
        if(start > end){
            nodeList.add(null);
            return nodeList;
        }

        for(int i = start ; i <= end ; i++){
            // 左节点
            List<TreeNode> leftNodeList = addChild(start,i-1);
            // 右节点
            List<TreeNode> rightNodeList = addChild(i+1,end);

            for(TreeNode leftNode : leftNodeList){
                for(TreeNode rightNode : rightNodeList){
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }


}
