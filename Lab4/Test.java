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
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        System.out.println(tree.isBST());
        tree.modify(4, 2);
        System.out.println(tree.isBST());

        BinaryTree tree2 = new BinaryTree();
        tree2.insert(5);
        tree2.insert(3);
        tree2.insert(4);
        System.out.println(tree2.isBST());
        tree2.modify(4, 6);
        System.out.println(tree2.isBST());

    }
}
