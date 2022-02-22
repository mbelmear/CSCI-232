package Lab4;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(44);
        tree.insert(55);
        tree.insert(33);
        tree.insert(69);
        tree.insert(22);
        System.out.println(tree.isBST());
        tree.modify(69, 50);
        System.out.println(tree.isBST());
    }
}
