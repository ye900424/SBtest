package bs.tree;

public class Test {
    TreeNode head;
    TreeNode pre;
    public TreeNode changeList(TreeNode root){
        head = null;
        pre = null;
        dfs(root);
        return head;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }

        dfs(root.left);
        if(pre == null){
            head = root;
        }else{
            pre.right = root;
            root.left = pre;
        }
        pre = root;


        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(25);

        Test test = new Test();
        TreeNode ret = test.changeList(root);
        System.out.println(ret);
    }
}
