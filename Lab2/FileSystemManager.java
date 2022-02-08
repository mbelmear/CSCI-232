package Lab2;

import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class FileSystemManager {

    private FileTree tree;

    public FileSystemManager() {
        tree = new FileTree();
    }

    public void run() {
        String command = " ";
        try (Scanner in = new Scanner(System.in)) {
            while (!command.equals("exit")) {
                System.out.print(tree.getCurrentLocation() + " % ");
                command = in.nextLine();
                executeCommand(command);
            }
        }
    }

    private void executeCommand(String command) {
        int breakPoint = command.indexOf(" ");
        String argument = null;
        if (breakPoint != -1) {
            argument = command.substring(breakPoint + 1, command.length());
            command = command.substring(0, breakPoint);
        }

        if (command.equals("cd")) {
            if (!move(argument)) {
                System.out.println("cd: no such file or directory: " + argument + "\n");
            }
        } else if (command.equals("ls")) {
            System.out.println(tree.getChildren());
        } else if (command.equals("mkdir")) {
            if (!tree.insert(argument)) {
                System.out.println("Invalid file name.\n");
            }
        } else if (command.equals("exit")) {

        } else if (command.equals("pwd")){
            System.out.println(tree.getPath());
        } else if (command.equals("rm")){
            tree.remove(argument);
        }else {
            System.out.println("'" + command + "' is not a recognized command");
        }
    }

    private boolean move(String file) {
        if (file == null || file.equals("") || file.equals("~")) {
            tree.goHome();
            return true;
        }

        if (file.equals("..")) {
            tree.moveUp();
            return true;
        }

        return tree.moveDown(file);
    }
    
    public void test() {  
        tree.insert("School");
        tree.moveDown("School");
        tree.insert("CSCI111");
        tree.insert("CSCI132");
        tree.moveDown("CSCI132");
        tree.insert("Inlabs");
        tree.goHome();
        
        tree.insert("Skiing");
        tree.moveDown("Skiing");
        tree.insert("Pictures");
        tree.insert("Trips");
        tree.insert("Gear");
        tree.moveDown("Trips");
        tree.insert("Summer");
        tree.moveDown("Summer");
        tree.insert("Tetons");
        tree.insert("AK");
        tree.moveUp();
        tree.insert("Winter");
        tree.goHome();
        
        tree.insert("Work");
        tree.moveDown("Work");
        tree.insert("Reviews");
        tree.insert("Paystubs");
        tree.moveDown("Paystubs");
        tree.insert("2014");
        tree.insert("2015");
        tree.goHome();
        
        tree.insert("Personal");
        tree.moveDown("Personal");
        tree.insert("Resume");
        tree.insert("Taxes");
        tree.goHome();
        
        run();
    }       
}
