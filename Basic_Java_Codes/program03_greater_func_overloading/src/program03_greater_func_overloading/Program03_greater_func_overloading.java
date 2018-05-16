/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program03_greater_func_overloading;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class Program03_greater_func_overloading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Three Numbers:");
        System.out.print("Enter the first number:\t");
        int n1 = sc.nextInt();
        System.out.print("Enter the Second number:\t");
        int n2 = sc.nextInt();
        System.out.print("Enter the Third number:\t");
        int n3 = sc.nextInt();
        Program03_greater_func_overloading obj = new Program03_greater_func_overloading();
        while(true) {
            menu();
            choice(n1, n2, n3);
        }
    }
    
    public static void menu() {
        System.out.println("MENU");
        System.out.println("1. Find the greatest number");
        System.out.println("2. Find the greater of the first and the second number");
        System.out.println("3. Find the greater of the second and the third number");
        System.out.println("4. Find the greater of the first and the third number");
        System.out.println("0. Exit");
    }
    
    public static void choice (int n1, int n2, int n3) {
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter your choice:\t");
            ch = sc.nextInt ();
            if (ch < 0 || ch > 4) {
                System.out.println("The entered choice is INVALID. Please enter VALID choice.");
                continue;
            }
            break;
        }while(true);
        switch (ch) {
            case 1 : System.out.println("The greatest number is " + greatest (n1, n2, n3) + ".");
            break;
            case 2 : System.out.println("The greater number is " + greatest (n1, n2) + ".");
            break;
            case 3 : System.out.println("The greater number is " + greatest (n2, n3) + ".");
            break;
            case 4 : System.out.println("The greater number is " + greatest (n1, n3) + ".");
            break;
            case 0 : System.exit (0);
        }
    }
    
    public static int greatest (int n1, int n2, int n3) {
        return n1>n2?n1>n3?n1:n3:n2>n3?n2:n3;
    }
    
    public static int greatest (int n1, int n2) {
        return n1>n2?n1:n2;
    }
}
