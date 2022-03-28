package Project1;

public class Node {

    private String characteristic;
    private Node left;
    private Node right;
    private Node parent;
    private String name;
    
    public Node(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getCharacteristic() {
        return characteristic;
    }
    
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.setParent(this);
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
        right.setParent(this);
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

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
