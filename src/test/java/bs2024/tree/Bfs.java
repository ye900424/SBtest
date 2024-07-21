package bs2024.tree;

public class Bfs {
    public static void main(String[] args){
        TreeNode root = TreeUtil.create(10);
        System.out.println(root);


        TreeUtil.bfs(root);

    }
}
