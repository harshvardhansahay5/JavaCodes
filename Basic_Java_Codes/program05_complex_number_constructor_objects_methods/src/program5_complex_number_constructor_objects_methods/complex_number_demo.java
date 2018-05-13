/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program5_complex_number_constructor_objects_methods;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class complex_number_demo {
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // TODO code application logic here
        double r, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two complex numbers:");
        System.out.println("\n\nFirst Complex Number c1:");
        System.out.print("Enter the REAL PART :\t");
        r = sc.nextDouble();
        System.out.print("Enter the IMAGINARY PART :\t");
        i = sc.nextDouble();
        complex_number c1 = new complex_number(r, i);
        System.out.println("\n\nSecond Complex Number c2:");
        complex_number c2 = new complex_number();
        c2.read();
        System.out.print("\n");
        System.out.print("c1 = ");
        c1.display();
        System.out.print("\n");
        System.out.print("c2 = ");
        c2.display();
        System.out.print("\n\n\n");
        while(true) {
            menu ();
            choice (c1, c2);
        }
    }
    
    public static void menu () {
        System.out.println("MENU");
        System.out.println("1. Add");
        System.out.println("2. Subract");
        System.out.println("3. Multipy");
        System.out.println("4. Divide");
        System.out.println("0. Exit");
    }
    
    public static void choice (complex_number c1, complex_number c2) {
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter your choice:\t");
            ch = sc.nextInt();
            if(ch < 0 || ch > 4) {
                System.out.println("The entered choice is INVALID. Please enter VALID choice.");
                continue;
            }
            break;
        }while(true);
        complex_number c3 = new complex_number();
        switch(ch) {
            case 1 : c3 = c1.add(c2);
                     System.out.print("c1 + c2 = ");
            break;
            case 2 : c3 = c1.sub(c2);
                     System.out.print("c1 - c2 = ");
            break;
            case 3 : c3 = c1.multi(c2);
                     System.out.print("c1 x c2 = ");
            break;
            case 4 : c3 = c1.divi(c2);
                     System.out.print("c1 / c2 = ");
            break;
            case 0 : System.exit (0);
        }
        c3.display();
        System.out.print("\n\n\n");
    }  
    
}