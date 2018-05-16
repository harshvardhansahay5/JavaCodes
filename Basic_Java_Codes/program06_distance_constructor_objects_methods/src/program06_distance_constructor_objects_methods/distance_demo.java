/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program06_distance_constructor_objects_methods;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class distance_demo {
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // TODO code application logic here
        double f, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two distances:");
        System.out.println("\n\nFirst Distance d1:");
        System.out.print("Enter feets :\t");
        f = sc.nextDouble();
        System.out.print("Enter inches :\t");
        i = sc.nextDouble();
        distance d1 = new distance(f, i);
        System.out.println("\n\nSecond Distance d2:");
        distance d2 = new distance();
        d2.get();
        System.out.print("\n");
        System.out.print("d1 = ");
        d1.display();
        System.out.print("\n");
        System.out.print("d2 = ");
        d2.display();
        System.out.print("\n\n\n");
        while(true) {
            menu ();
            choice (d1, d2);
        }
    }
    
    public static void menu () {
        System.out.println("MENU");
        System.out.println("1. Add");
        System.out.println("2. Subract");
        System.out.println("0. Exit");
    }
    
    public static void choice (distance d1, distance d2) {
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter your choice:\t");
            ch = sc.nextInt ();
            if(ch < 0 || ch > 2) {
                System.out.println("The entered choice is INVALID. Please enter VALID choice.");
                continue;
            }
            break;
        }while(true);
        distance d3 = new distance();
        switch(ch) {
            case 1 : d3 = d1.add(d2);
                     System.out.print("d1 + d2 = ");
            break;
            case 2 : d3 = d1.sub(d2);
                     System.out.print("d1 - d2 = ");
            break;
            case 0 : System.exit (0);
        }
        d3.display();
        System.out.print("\n\n\n");
    }    
}
