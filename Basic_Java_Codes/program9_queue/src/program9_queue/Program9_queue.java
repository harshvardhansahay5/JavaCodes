/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program9_queue;

import java.util.Scanner;

/**
 *
 * @author harshvardhansahay
 */
public class Program9_queue {

    static int front = -1, rear = -1, q[];
    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Enter the maximum number of elements in the queue:\t");
	q = new int[sc.nextInt()];
	while (true) {
		menu();
		choice();
	}
    }
    
    public static void menu() {
	System.out.print("MENU");
	System.out.print("\n1. To Insert An Element In The Queue");
	System.out.print("\n2. To Delete An Element From The Queue");
	System.out.print("\n3. Display The Queue");
	System.out.println("\n0. Exit");
    }
    
    public static void choice() {
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
	case 1: insert();
	break;
	case 2: delete();
	break;
	case 3: display();
	break;
	case 0: System.exit(0);
	}
    }
    
    public static void insert() {
        if (rear == (q.length - 1)) {
            System.out.print("!!!!OVERFLOW!!!!\n");
	}
        else if (rear == -1) {
            front = rear = 0;
            System.out.print("Enter The Element To Be Inserted:");
            q[rear] = sc.nextInt();
            System.out.print("Element Inserted\n");
	}
        else {
            rear++;
            System.out.print("Enter The Element To Be Inserted:");
            q[rear] = sc.nextInt();
            System.out.print("Element Inserted\n\n\n");
	}
    }
    public static void delete() {
	if (front == -1) {
            System.out.print("!!!!UNDERFLOW!!!!\n\n\n");
	}
        else {
            System.out.print("The Element " + q[front] + " is Deleted\n\n\n");
            if (front == rear)
                front = rear = -1;
            else front++;
	}
}

    public static void display() {
	int p;
	if (front == -1) {
            System.out.print("!!!!NO Element Inserted!!!!\\n\n\n");
	}
        else {
            p = front;
            for (; p < rear; ++p)
		System.out.print(q[p] + "->");
            System.out.print(q[p] + "\n\n\n");
	}
    }
}