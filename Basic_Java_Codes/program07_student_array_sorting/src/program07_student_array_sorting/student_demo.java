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
public class student_demo {
    /**
     * @param args the command line arguments
     */  
    static student_details s[];
    public static void main(String[] args) {
        // TODO code application logic here
        while(true) {
            menu();
            choice();
        }
    }
    
    public static void menu () {
        System.out.println("MENU");
        System.out.println("1. Insert Details");
        System.out.println("2. Sort");
        System.out.println("3. Display the list");
        System.out.println("0. Exit");
    }
    
    public static void choice () {
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter your choice:\t");
            ch = sc.nextInt ();
            if(ch < 0 || ch > 3) {
                System.out.println("The entered choice is INVALID. Please enter VALID choice.");
                continue;
            }
            break;
        }while(true);
        switch(ch) {
            case 1 : int num;
                     System.out.print("Enter the number of students in the list:\t");
                     num = sc.nextInt();
                     s = new percentage[num];
                     for(int i = 0; i < s.length; ++i, System.out.println("\n\n")) {
                        System.out.println("Student:\t" + (i + 1));
                        s[i] = new percentage();
                        s[i].get();
                     }
            break;
            case 2 : bubblesort();
            break;
            case 3 : for(int i = 0; i < s.length; ++i, System.out.println("\n\n")) {
                        System.out.println("Student:\t" + i + 1);
                        s[i].put();
                     }
            break;
            case 0 : System.exit (0);
        }
    }
    public static void bubblesort() {
        int i, j;
        student_details t = new percentage();
	for (i = 0; i < s.length - 1; ++i) {
            for (j = 0; j < s.length - i - 1; ++j) {
		if (s[j].getperc() > s[j + 1].getperc()) {
                   t = s[j];
                   s[j] = s[j + 1];
                   s[j + 1] = t;
		}
            }
	}
        System.out.println("The array has been sorted.\n");
    }
}