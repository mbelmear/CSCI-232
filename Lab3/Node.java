package Lab3;
import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class Node {
    private String name;
    private Node parent;
    private ArrayList<Node> children;
    
    public Node(String name) {
        this.name = name;
        children = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public Node getParent() {
        return parent;
    }
    
    public ArrayList<Node> getChildren() {
        return children;
    }
    
    public void addChild(Node child) {
        children.add(child);
    }
}
