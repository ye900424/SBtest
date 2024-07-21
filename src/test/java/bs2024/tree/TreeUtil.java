package bs2024.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TreeUtil {

    public static TreeNode create(int size){
        int i = 1;
        TreeNode root = new TreeNode(i);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()){
            TreeNode treeNode = deque.remove();
            treeNode.left = new TreeNode(++i);
            deque.add(treeNode.left);
            if(i == size) break;
            treeNode.right = new TreeNode(++i);
            deque.add(treeNode.right);
            if(i == size) break;
        }
        return root;
    }

    public static void bfs(TreeNode node){
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(node);
        while (!deque.isEmpty()){
            int count = deque.size();
            for(int i = 0 ; i < count ; i++){
                TreeNode cur = deque.pop();
                System.out.print(cur.val + " | ");
                if(cur.left != null) deque.add(cur.left);
                if(cur.right != null) deque.add(cur.right);
            }
            System.out.println();
        }
    }

    public static void printFromLeft(TreeNode node) {
        if (node == null) {
            return;
        }
        printFromLeft(node.left);
        System.out.print(node.val);
        printFromLeft(node.right);
    }

    public static void printFromLeft(List<TreeNode> nodes) {
        for(TreeNode node : nodes){
            printFromLeft(node);
            System.out.println("——————");
        }
    }


    public static void printFromMid(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val);
        printFromMid(node.left);
        printFromMid(node.right);
    }

    public static void printFromMid(List<TreeNode> nodes) {
        for(TreeNode node : nodes){
            printFromMid(node);
            System.out.println("——————");
        }
    }
}
