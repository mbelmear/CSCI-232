package Lab4;
/**
 *
 * @author yaw
 */

import java.util.ArrayList;

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
        ArrayList<Integer> aslist = getelementsordered(root);
        for (int i = 1; i < aslist.size(); i++){
            if(aslist.get(i) <= aslist.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> getelementsordered(Node root){
        //create a new array list, add result from the left, add the center, add the result from the right 
        //if root is null then we just return an empty list
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result.addAll(getelementsordered(root.getLeft()));
        result.add(root.getValue());
        result.addAll(getelementsordered(root.getRight()));
        return result;
    }

}
