package bs.tree;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class BSTToDoublyLinkedList {

    private TreeNode head, prev;

    // Helper method to perform the conversion
    private void convertBSTToDoublyLinkedList(TreeNode root) {
        if (root == null) return;

        // Perform in-order traversal
        convertBSTToDoublyLinkedList(root.left);

        // Process current node
        if (prev == null) {
            // If this is the first node being processed, set it as head
            head = root;
        } else {
            // Link previous node with current node
            prev.right = root;
            root.left = prev;
        }
        // Update previous node for next iteration
        prev = root;

        // Continue with the right subtree
        convertBSTToDoublyLinkedList(root.right);
    }

    // Public method to start conversion
    public TreeNode bstToDll(TreeNode root) {
        head = null;
        prev = null;
        convertBSTToDoublyLinkedList(root);
        return head;
    }

    // Method to print the doubly linked list
    public static void printDoublyLinkedList(TreeNode head) {
        TreeNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(25);

        BSTToDoublyLinkedList converter = new BSTToDoublyLinkedList();
        TreeNode dllHead = converter.bstToDll(root);

        // Print the converted doubly linked list
        printDoublyLinkedList(dllHead);
    }
}
//代码解释
//TreeNode 类：定义了二叉树节点的数据结构，每个节点包含一个整数值 val 和两个指向子节点的引用 left 和 right。
//convertBSTToDoublyLinkedList 方法：这是一个递归方法，用于执行中序遍历并构建双向链表。它首先处理左子树，然后处理当前节点，最后处理右子树。对于每个节点，它会将其与前一个节点链接起来，并更新 prev 引用来跟踪最后一个处理过的节点。
//bstToDll 方法：这是对外公开的方法，初始化 head 和 prev 变量，然后调用辅助方法开始转换过程。最终返回双向链表的头部节点。
//printDoublyLinkedList 方法：用于打印双向链表的内容，以便验证转换结果。
//main 方法：创建了一个简单的二叉搜索树实例，并调用了转换方法，最后打印出转换后的双向链表。
//通过这种方式，你可以在不使用额外空间的情况下将二叉搜索树转换为双向链表，并且保留原始树的 left 和 right 指针来表示链表的前后关系。
//
//代码模式
//如何在双向链表中插入节点？
//如何在双向链表中删除节点？
//双向链表的性能如何？
//代码模式
//        深度搜索
//PPT创作
//        指令中心
//服务生成的所有内容均由人工智能模型生成，其生成内容的准确性和完整性无法保证，不代表我们的态度或观点


