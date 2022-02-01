package Lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class Node {
    private Node next;
    
    private Student student;
    
    public Node(Student student) {
        this.student = student;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public Student getStudent() {
        return student;
    }
}
