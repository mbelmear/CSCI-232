package Lab5;
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
        
        System.out.println();
        System.out.println("Full Student Database:");
        System.out.println();
        database.addStudent("Joe Schmo", 1101, 3.3);
        database.addStudent("Katie Katerson", 31415926, 3.8);
        database.addStudent("Watson TheBassetHound", 12345, 3.5);
        database.addStudent("Joe Schmo", 3323131, 3.5);
        database.addStudent("Watson TheBassetHound", 2232311, 3.4);
        database.addStudent("Michael Belmear", 1016467, 4.13);
        database.addStudent("Michael Belmear", 2649433, 3.8);
        database.printDatabase();
        database.countStudentsByName();
        database.findStudentByID(2232311);
        database.findStudentByID(1016467);
        System.out.println();
        database.printStudentsByGPA();
        System.out.println();
    }
    
}
