package Lab4;
/**
 *
 * @author yaw
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            boolean placed = false;
            while (!placed) {
                if (newValue < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(newValue));
                        currentNode.getRight().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }

    public void modify(int oldValue, int newValue) {
        if (root != null) {
            Node currentNode = root;
            boolean found = false;
            while (!found) {
                if (oldValue < currentNode.getValue()) {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                    } else {
                        System.out.println("Value not in tree.");
                        found = true;
                    }
                } else if (oldValue > currentNode.getValue()) {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                    } else {
                        System.out.println("Value not in tree.");
                        found = true;
                    }
                } else {
                    currentNode.setValue(newValue);
                    found = true;
                }
            }
        }
    }

    public boolean isBST() {
        return verifybst(root);
        //will return true if instance of bt is a bst and false if not
        //if instance of binary tree happens to fall into binary search tree
            //return true
        //else return false
    }

    private boolean verifybst(Node root){
        if (root == null){
            return true;
        }
        if (root.getRight() != null && root.getRight().getValue() <= root.getValue()){
            return false;
        }
        if (root.getLeft() != null && root.getLeft().getValue() >= root.getValue()){
            return false;
        }
        return verifybst(root.getLeft()) && verifybst(root.getRight());
    }
}
