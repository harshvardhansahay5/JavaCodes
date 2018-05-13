/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program9_student_interface;

import java.util.*;

/**
 *
 * @author harshvardhansahay
 */
public class student {
    String Enrollment_No, Name, DOB;
    Scanner sc = new Scanner(System.in);
    
    student () {
        Enrollment_No = Name = DOB = "";
    }
    
    public void get () {
        System.out.print("Enter enrollment number:\t");
        Enrollment_No = sc.nextLine();
        System.out.print("Enter Name:\t");
        Name = sc.nextLine();
        System.out.print("Enter Date of Birth:\t");
        DOB = sc.nextLine();
    }
}
