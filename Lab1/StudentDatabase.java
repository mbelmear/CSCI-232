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
public class StudentDatabase {

    private Student[] database;

    public StudentDatabase() {
        database = new Student[0];
    }

    public void addStudent(String name, int studentNumber, double gpa) {
        Student newStudent = new Student(name, studentNumber, gpa);
        Student[] tempDatabase = new Student[database.length + 1];

        for (int i = 0; i < database.length; i++) {
            tempDatabase[i] = database[i];
        }

        tempDatabase[database.length] = newStudent;
        database = tempDatabase;
    }

    public void printDatabase() {
        for (int i = 0; i < database.length; i++) {
            Student student = database[i];
            System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
        }
        System.out.println();
    }
    
    public void copyStudent(int idNumber) {
        Student[] tempDatabase = new Student[database.length + 1];

        for (int i = 0; i < database.length; i++) {
            tempDatabase[i] = database[i];
            if (database[i].getIdNumber() == idNumber) {
                //tempDatabase[database.length] = database[i];
                tempDatabase[database.length] = new Student(database[i].getName(), database[i].getIdNumber(), database[i].getGPA());
            }
        }

        database = tempDatabase;
    }
    
    public void updateGPA(int index, double newGPA) {
        database[index].changeGPA(newGPA);
    }


    public void findStudentByIndex(int index){//O(1)
        Student student = database[index];
        System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
        //for each student in the database/array
            //if the chosen index matches the student's index
            //print the students information
            
    }

    public void findStudentsByName(String name){//O(n)
        for (int i = 0; i < database.length; i++) {
            Student cur = database[i];
            if (name.equals(cur.getName())){
                System.out.println(cur.getName() + ": (ID=" + cur.getIdNumber() + "), (gpa=" + cur.getGPA() + ")");
            }
        }
        //for each student in the database/array
            //if the chosen name matches the student's name 
            //print the student's information
            //otherwise, keep iterating through
    }

    public void removeStudent(int id){//O(n)
        Student[] tempDatabase = new Student[database.length -1];
        int index = 0;

        for (int i = 0; i < database.length; i++) {
            Student cur = database[i];
            if (cur.getIdNumber() != id){
                tempDatabase[index] = cur;
                index++;
            }
        }
        database = tempDatabase;
        //for each student in the database
            //if the chosen student id number matches a number in the database/array
            //remove the student from the index
            //otherwise, keep iterating through
    }

}
