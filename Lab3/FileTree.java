package Lab3;
import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class FileTree {

    private Node root;
    private Node current;

    public FileTree() {
        root = new Node("~");
        current = root;
    }

    public String getCurrentLocation() {
        return current.getName();
    }
    
    public boolean moveDown(String directory) {
        ArrayList<Node> children = current.getChildren();
        for (Node child : children) {
            if (directory.equals(child.getName())) {
                current = child;
                return true;
            }
        }
        return false;
    }

    public void moveUp() {
        if (current != root) {
            current = current.getParent();
        }
    }

    public void goHome() {
        current = root;
    }

    public String getChildren() {
        String files = new String();
        ArrayList<Node> children = current.getChildren();
        for (Node c : children) {
            files += c.getName() + " ";
        }
        return files;
    }

    public boolean insert(String directory) {
        if (directory != null && !directory.equals(" ")) {
            Node newFile = new Node(directory);
            newFile.setParent(current);
            current.addChild(newFile);
            return true;
        }
        return false;
    }
    
    public String getSubTree() {
       return tree(current, 0);//calling our recursive method
    }

    private String tree(Node node, int depth){
        String aids = "";//creating an empty string to concatenate our output to 
        for (int i = 0; i < depth - 1; i++){
            aids += "|   ";//at each depth, add a "|" to the empty string
        }
        if (depth != 0){
            aids += "|---";//if the depth is not at 0 or at the root, add a "|" and "---" to the empty string
        }
        aids += node.getName();//add the name of each node to the empty string
        for (Node child : node.getChildren()){
            aids += '\n'+ tree(child, depth + 1);//go down and start a new line at each depth
        }
        return aids;//return our formatted string 
    }
}

