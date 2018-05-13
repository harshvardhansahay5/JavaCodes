/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program2_matrix_operations;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class Program2_matrix_operations {
    /**
     * @param args the command line arguments
     */

    static int mat1 [][], mat2 [][];
    
    public static void main(String[] args) {
        // TODO code application logic here
        while(true) {
            menu ();
            choice ();
        }
    }
    
    public static void menu () {
        System.out.println("MENU");
        System.out.println("1. Enter the Matrices");
        System.out.println("2. Display the Matrices");
        System.out.println("3. Addition");
        System.out.println("4. Subtraction");
        System.out.println("5. Multiplication");
        System.out.println("0. Exit");
    }
    
    public static void choice () {
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter your choice:\t");
            ch = sc.nextInt ();
            if (ch < 0 || ch > 5) {
                System.out.println("The entered choice is INVALID. Please enter VALID choice.");
                continue;
            }
            break;
        }while(true);
        switch (ch) {
            case 1 : getmats ();
            break;
            case 2 : display (0);
            break;
            case 3 : add ();
            break;
            case 4 : sub ();
            break;
            case 5 : multi ();
            break;
            case 0 : System.exit (0);
        }
    }
    
    public static void getmats () {
        int r1, c1, r2, c2;
        System.out.print("Enter the order of matrices\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows in the first matrix:\t");
        r1 = sc.nextInt();
        System.out.print("Enter the number of columns in the first matrix:\t");
        c1 = sc.nextInt();
        System.out.print("Enter the number of rows in the second matrix:\t");
        r2 = sc.nextInt();
        System.out.print("Enter the number of columns in the second matrix:\t");
        c2 = sc.nextInt();
        mat1 = new int [r1][c1];
        mat2 = new int [r2][c2];
        System.out.print("Enter the elements of the first matrix:\n");
        for(int i = 0; i < mat1.length; ++i)
            for(int j = 0; j < mat1 [0].length; ++j) {
                System.out.print("Enter the element (" + i + ", " + j + "):\t");
                mat1 [i][j] = sc.nextInt();
            }
        display(1);
        System.out.print("Enter the elements of the second matrix:\n");
        for(int i = 0; i < mat2.length; ++i)
            for(int j = 0; j < mat2 [0].length; ++j) {
                System.out.print("Enter the element (" + i + ", " + j + "):\t");
                mat2 [i][j] = sc.nextInt();
            }
        display(2);
    }
    
    public static void display (int i) {
        switch(i) {
            case 0 :
            case 1 : System.out.print("First matrix:\n");
                        for(int j = 0; j < mat1.length; ++j, System.out.print("\n"))
                            for(int k = 0; k < mat1 [0].length; ++k) {
                                System.out.print(mat1 [j][k] + "\t");
                            }
                     if(i == 1) break;
            case 2 : System.out.print("Second matrix:\n");
                        for(int j = 0; j < mat2.length; ++j, System.out.print("\n"))
                            for(int k = 0; k < mat2 [0].length; ++k) {
                                System.out.print(mat2 [j][k] + "\t");
                            }
        }
    }
    
    public static void add () {
        if(mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
                System.out.println("Addition not possible as orders of the matrices are different.\n\n");
                return;
        }
        System.out.println("The sum of the matrices is:\n");
        for(int i = 0; i < mat1.length; ++i, System.out.print("\n"))
            for(int j = 0; j < mat1 [0].length; ++j) {
                System.out.print(mat1 [i][j] + mat2 [i][j]+ "\t");
            }
    }
    
    public static void sub () {
        if(mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
                System.out.println("Subtraction not possible as orders of the matrices are different.\n\n");
                return;
        }
        System.out.println("The difference of the matrices is:\n");
        for(int i = 0; i < mat1.length; ++i, System.out.print("\n"))
            for(int j = 0; j < mat1 [0].length; ++j) {
                System.out.print(mat1 [i][j] - mat2 [i][j] + "\t");
            }
    }
    
    public static void multi () {
        if(mat1[0].length != mat2.length) {
                System.out.println("Multiplication not possible as the number of columns of the first matix and number of rows of the second matrix are different.\n\n");
                return;
        }
        int temp = 0;
        System.out.println("The product of the matrices is:\n");
        for(int i = 0; i < mat1.length; ++i, System.out.print("\n"))
            for(int j = 0; j < mat2 [0].length; ++j, System.out.print("\t")) {
                for(int k = 0; k < mat1 [0].length; ++k) {
                   if(k == 0)
                       temp = 0;
                   temp += mat1 [i][k] * mat2 [k][j];
                }    
                System.out.print(temp);
            }
    }
}