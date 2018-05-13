/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program8_stack;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class Program8_stack {

    /**
     * @param args the command line arguments
     */
    static int top = -1, st[];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Enter the maximum number of elements in the stack:\t");
	st = new int[sc.nextInt()];
	while (true) {
		menu();
		choice();
	}
    }
    
    public static void menu () {
        System.out.println("MENU");
        System.out.println("1. To PUSH An Element In The Stack");
        System.out.println("2. To POP An Element From The Stack");
        System.out.println("3. Display The Stack");
        System.out.println("0. Exit");
    }
    
    public static void choice () {
        int ch;
        do {
            System.out.print("Enter your choice:\t");
            ch = sc.nextInt ();
            if (ch < 0 || ch > 3) {
                System.out.println("The entered choice is INVALID. Please enter VALID choice.");
                continue;
            }
            break;
        }while(true);
        switch (ch) {
            case 1: push();
            break;
            case 2: pop();
            break;
            case 3: display();
            break;
            case 0: System.exit(0);
            break;
	}
    }
    
    public static void push () {
        if(top == (st.length - 1)) {
            System.out.print("!!!!OVERFLOW!!!!\n\n\n");
	}
        else {
            System.out.print("Enter The Element To Be Inserted:");
            st[++top] = sc.nextInt();
            System.out.print("Element Inserted\n\n\n");
	}
    }
    
    public static void pop () {
        if (top == -1) {
		System.out.print("!!!!UNDERFLOW!!!!\n\n\n");
	} else {
		System.out.print("The Element " + st[top--] + " is Deleted\n\n\n");
	}
    }
    public static void display() {
	int p = top;
	if (top == -1) {
            System.out.print("!!!!NO Element Inserted!!!!\n\n\n");
	}
        else {
            for( ; p > 0; --p)
                System.out.print(st[p] + "->");
            System.out.println(st[p] + "\n\n");
        }
    }
}
