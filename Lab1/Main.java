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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        System.out.println("Full unaltered database:");
        database.addStudent("Joe Schmo", 1101, 3.2);
        database.addStudent("Katie Katerson", 31415926, 3.7);
        database.addStudent("Watson TheBassetHound", 12345, 2.4);
        database.printDatabase();
        System.out.println("Find Student by Index:");
        database.findStudentByIndex(1);
        System.out.println();
        System.out.println("Find Student by Name:");
        database.findStudentsByName("Watson TheBassetHound");
        System.out.println();
        System.out.println("Remove a student from the database:");
        database.removeStudent(1101);
        database.printDatabase();
        System.out.println("Remove another student from the database:");
        database.removeStudent(12345);
        database.printDatabase();

        System.out.println();
        StudentDatabaseLL databasell = new StudentDatabaseLL();
        System.out.println();
        System.out.println("Full unaltered linked list database:");
        databasell.addStudent("Joe Schmo", 1101, 3.2);
        databasell.addStudent("Katie Katerson", 31415926, 3.7);
        databasell.addStudent("Watson TheBassetHound", 12345, 2.4);
        databasell.printDatabase();
        System.out.println("Find Student by Index:");
        databasell.findStudentByIndex(1);
        System.out.println();
        System.out.println("Find Student by Name:");
        databasell.findStudentsByName("Watson TheBassetHound");
        System.out.println();
        System.out.println("Remove a student from the database/linked list:");
        databasell.removeStudent(1101);
        databasell.printDatabase();
        System.out.println("Remove another student from the database/linked list:");
        databasell.removeStudent(12345);
        databasell.printDatabase();
        
    }  
}
