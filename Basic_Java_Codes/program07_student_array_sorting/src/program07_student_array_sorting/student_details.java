/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program07_student_array_sorting;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
abstract class student_details {
    int sid;
    String name = new String(), course = new String(), dept = new String();
    
    student_details() {
        name = course = dept = "";
        sid = 0;
    }
    
    public void get() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the student ID:\t");
        sid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the student's name:\t");
        name = sc.nextLine();
        System.out.print("Enter the student's course:\t");
        course = sc.nextLine();
        System.out.print("Enter the student's Department:\t");
        dept = sc.nextLine();
    }
    
    abstract double getperc();
    
    public void put() {
        System.out.println("Student ID:\t" + sid);
        System.out.println("Name:\t" + name);
        System.out.println("Course:\t" + course);
        System.out.println("Department:\t" + dept);
    }
}
