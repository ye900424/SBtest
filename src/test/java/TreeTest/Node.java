package TreeTest;

/**
 * 定义一个节点Node类，用来存储每个节点的内容
 * Created by caoyang on 2017/6/10.
 */
public class Node<T> {
    private T data;
    private int parent;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, int parent) {
        this.data = data;
        this.parent = parent;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getParent() {
        return this.parent;
    }
}
