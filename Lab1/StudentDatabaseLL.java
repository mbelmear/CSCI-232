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
public class StudentDatabaseLL {
    
    public Node firstNode;
    public Node lastNode;
    
    public StudentDatabaseLL() {
        
    }
    
    public void addStudent(String name, int studentNumber, double gpa) {
        Student newStudent = new Student(name, studentNumber, gpa);
        Node newNode = new Node(newStudent);
        
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
    }
    
    public void printDatabase() {
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.getStudent().getName() + ": (ID=" + currentNode.getStudent().getIdNumber() + "), (gpa=" + currentNode.getStudent().getGPA() + ")");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }


    public void findStudentByIndex(int index){//O(n)
        Node currentNode = firstNode;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }
        Student student = currentNode.getStudent();
        System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
        //for each student/node in the linked list
            //if the chosen index matches the student's index
            //print the students information
            //otherwise, keep iterating through
    }

    public void findStudentsByName(String name){//O(n)
        Node currentNode = firstNode;
        while (currentNode != null){
            if (currentNode.getStudent().getName().equals(name)){
                Student cur = currentNode.getStudent();
                System.out.println(cur.getName() + ": (ID=" + cur.getIdNumber() + "), (gpa=" + cur.getGPA() + ")");
            }
            currentNode = currentNode.getNext();
        }
        //for each student/node in the linked list
            //if the chosen name matches the student's name 
            //print the student's information
            //otherwise, keep iterating through
    }

    public void removeStudent(int id){//O(n)
        Node currentNode = firstNode;
        Node previousNode = null;
        while (currentNode != null){
            if (currentNode.getStudent().getIdNumber() == id){
                if (previousNode == null){
                    firstNode = currentNode.getNext();
                    break;
                }
               previousNode.setNext(currentNode.getNext());
               break;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        //for each student/node in the linked list
            //if the chosen student id number matches a number in the linked list
            //remove the student's node from the linked list 
            //otherwise, keep iterating through
    }
}
