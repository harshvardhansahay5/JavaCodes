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
public class student_interface_demo {
    public static void main (String[] args) {
        int num;
        System.out.print("Enter the number of students:\t");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        result res[] = new result[num];
        for(int i = 0; i < num; ++i) {
            res[i] = new result();
            res[i].get();
            System.out.println("\n\n");
        }
        for(int i = 0; i < num; ++i) {
            res[i].put();
            System.out.println("\n\n");

        }
    }
}
