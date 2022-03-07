package Lab5;
import java.util.HashMap;
import java.util.HashSet;


/**
 *
 * @author yaw
 */
public class StudentDatabase {

    private HashMap<String, HashSet<Student>> database;

    public StudentDatabase() {
        database = new HashMap<>();
    }

    public void addStudent(String name, int studentNumber, double gpa) {
        Student newStudent = new Student(name, studentNumber, gpa);
        if (!database.containsKey(name)) {
            database.put(name, new HashSet<>());
        }
        database.get(name).add(newStudent);
    }

    public void printDatabase() {
        for (String name : database.keySet()) {
            for (Student student : database.get(name)) {
                System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
            }
        }
        System.out.println();
    }

    public void removeStudent(String name) {
        database.remove(name);
    }

    public void countStudentsByName() {
        for (String name : database.keySet()) {//iterates through the keyset
            System.out.println(name + ": " + database.get(name).size());//prints the number of values associated with the key
        }
        System.out.println();      
    }

    public void findStudentByID(int id) {
        for (String name : database.keySet()) {     //iterates through key
            for (Student student : database.get(name)){ //iterates through value. Value = database.get(name)
                if (student.getIdNumber() == id){
                    System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
                }
            }
        }
        //loop through the whole hash map to searh for students with a particular id
        //if found, print it out, if not don't do anything or print an error statement 
    }

    public void printStudentsByGPA() {
        HashMap<Double, HashSet<Student>> gpahash = new HashMap<Double, HashSet<Student>>();
        for (String name : database.keySet()){
            for (Student student : database.get(name)){
                if(!gpahash.containsKey(student.getGPA())){
                    gpahash.put(student.getGPA(), new HashSet<>());
                }
                gpahash.get(student.getGPA()).add(student);
            }
        }
        for (Double gpa : gpahash.keySet()){
            System.out.println(gpa);
            for (Student student : gpahash.get(gpa)){
                System.out.println(student.getName());               
            }          
        }
        //create a new hashmap that hashes gpa to hashsets of students
        //populate the new hashmap
        //gonna go through and print each gpa to each student similar to how we printed the database to each name
       
    }
}