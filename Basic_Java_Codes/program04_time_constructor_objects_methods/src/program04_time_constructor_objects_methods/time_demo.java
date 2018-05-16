/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program04_time_constructor_objects_methods;
import java.util.Scanner;
/**
 *
 * @author harshvardhansahay
 */
public class time_demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int day, hr, min, sec;
        System.out.println("Enter the time t1:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter days:\t");
        day = sc.nextInt();
        System.out.print("Enter hours:\t");
        hr = sc.nextInt();
        System.out.print("Enter minutes:\t");
        min = sc.nextInt();
        System.out.print("Enter seconds:\t");
        sec = sc.nextInt();
        time t1 = new time(day, hr, min, sec);
        System.out.println("\nTime t1:");
        t1.put();
        time t2 = new time();
        System.out.println("\n\nEnter the time t2:");
        t2.get();
        System.out.println("Time t2:");
        t2.put();
        System.out.println("\n\nAdding time t1 and t2 and assigning the result in t1:");
        t1 = t1.add(t2);
        System.out.println("\n\nDisplaying updated t1:");
        t1.put();
    }
}