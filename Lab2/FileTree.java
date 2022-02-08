package Lab2;

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
        // if path exists, move to the final directory in the path
        // otherwise print out an error message and return false
        String[] dirs = directory.split("/");
        Node temp = current;
        for (int i = 0; i < dirs.length; i++){
            String moveinto = dirs[i];
            Node tomoveinto = null;
            for (Node child : temp.getChildren()){
                if(child.getName().equals(moveinto)){
                    tomoveinto = child;
                    break;
                }           
            }
            if(tomoveinto == null){
                System.out.println("Unable to move into " + moveinto);
                return false;
            }
            temp = tomoveinto;
        }
        current = temp;
        return true;
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

    public String getPath() {
        // for the node we are currently in, print out the path to the root
        // look at the parent, keep track of the parent and put it into either an array
        // or a string
        // make parent the current node until we get to the root or the null node
        // if there is a parent, if its not root/null, save it as a string, set the
        // current node equal to the parent, then save the next node to the list
        ArrayList<Node> arrayList = new ArrayList<>();
        Node path = current;
        while (path != null) {
            arrayList.add(path);
            path = path.getParent();
        }
        String pp = "";
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            pp = pp + "/" + arrayList.get(i).getName();
        }
        return pp;
    }

    public boolean remove(String directory) {
        for (Node child : current.getChildren()) {
            if (child.getName().equals(directory)) {
                current.getChildren().remove(child);
                return true;
            }
        }
        System.out.println("The chosen directory only exists in your imagination, check heap-imagination connection may be faulty.");
        return false;

        // if directory is equal to the chosen directory
        // remove the directory from the tree
        // return true
        // else return false
    }

}
