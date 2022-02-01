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
public class Student {
    private String name;
    private double gpa;
    private int idNumber;
    
    public Student (String name, int idNumber, double gpa) {
        this.name = name;
        this.idNumber = idNumber;
        this.gpa = gpa;
    }
    
    public String getName() {
        return name;
    }
    
    public int getIdNumber() {
        return idNumber;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public void changeGPA(double inputGpa) {
        gpa = inputGpa;
    }
}
