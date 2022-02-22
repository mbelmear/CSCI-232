package Lab4;
/**
 *
 * @author yaw
 */
public class Node {

    private int value;
    private Node left;
    private Node right;
    private Node parent;
    
    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

}
