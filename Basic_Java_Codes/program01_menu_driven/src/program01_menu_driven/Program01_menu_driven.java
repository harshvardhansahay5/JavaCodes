/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program01_menu_driven;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class Program01_menu_driven {
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // TODO code application logic here
        while(true) {
            menu ();
            choice ();
        }
    }
    
    public static void menu () {
        System.out.println("MENU");
        System.out.println("1. Prime or Composite");
        System.out.println("2. Even or Odd");
        System.out.println("3. Armstrong Check");
        System.out.println("4. Factorial");
        System.out.println("5. Palindrome");
        System.out.println("6. Fibonacci");
        System.out.println("7. Sum of Digits");
        System.out.println("8. Table");
        System.out.println("0. Exit");
    }
    
    public static void choice () {
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter your choice:\t");
            ch = sc.nextInt ();
            if (ch < 0 || ch > 8) {
                System.out.println("The entered choice is INVALID. Please enter VALID choice.");
                continue;
            }
            break;
        }while(true);
        switch (ch) {
            case 1 : prime ();
            break;
            case 2 : even ();
            break;
            case 3 : armstrong ();
            break;
            case 4 : fact ();
            break;
            case 5 : pallind ();
            break;
            case 6 : fibo ();
            break;
            case 7 : sod ();
            break;
            case 8 : table ();
            break;
            case 0 : System.exit (0);
        }
    }
    
    public static int getnum () {
        System.out.print("Enter the Number:\t");
        Scanner sc = new Scanner(System.in);
        return Math.abs(sc.nextInt());
    }
    
    public static void prime () {
        int num = getnum();
        for (int i = 2; i <= Math.sqrt (num); ++i) {
            if (num%i == 0) {
                System.out.println("The entered number is Composite.\n\n");
                return;
            }
        }
        System.out.println("The entered number is Prime.\n\n");
    }
    public static void even () {
        if (getnum ()%2 == 0)
            System.out.println("The entered number is Even.\n\n");
        else
            System.out.println("The entered number is Odd.\n\n");
    }
    
    public static void armstrong () {
        int num = getnum(), scd = 0;
        int n = num;
        while (n != 0) {
            scd += Math.pow((n%10), 3);
            n /= 10;
        }
        if (num == scd) 
            System.out.println("The entered number is Armstrong.\n\n");
        else
            System.out.println("The entered number is not Armstrong.\n\n");
    }
    public static void fact () {
        System.out.print("Enter the Number:\t");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); long f = 1;
        if (num < 0) {            
            System.out.println("The entered number is negative. Hence, factorial doesn't exist.\n\n");
            return;
        }
        for (int i = num; i >= 2 ; --i) {
            f *= i;
        }
        System.out.println("The factorial of " + num + " is " + f + ".\n\n");        
    }
    
    public static void pallind () {
        int num = getnum(), pal = 0;
        int n = num;
        while (n != 0) {
            pal = pal*10 + n%10;
            n /= 10;
        }
        if(num == pal)
            System.out.println("The number is a palindrome.\n\n");
        else
            System.out.println("The number is not a palindrome.\n\n");
    }
    public static void fibo () {
        System.out.print("Enter the number of terms:\t");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); long f = 0, s = 1, next;
        System.out.println("Fibonacci series");
        if(num >= 1) {
                System.out.print(f + " ");
        }
        if(num >= 2) {
                System.out.print(s + " ");
        }
        for(int i = 3; i <= num; i++) {
            
            next = f + s;
            System.out.print(next + " ");
            f = s;
            s = next;
        }
        System.out.print("\n\n");
    }
    
    public static void sod () {
        int num = getnum(), sodi = 0;
        int n = num;
        while (n != 0) {
            sodi += n%10;
            n /= 10;
        }
        System.out.println("The Sum of Digits of the number " + num + " is " + sodi + ".\n\n");
    }
    
    public static void table () {
        System.out.print("Enter the Number:\t");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= 9; ++i) {
            System.out.println(num + " x " + i + "  = " + num*i);
        }
        System.out.println(num + " x " + 10 + " = " + num*10 + "\n\n");
    }
}