/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program10_student_interface;

/**
 *
 * @author harshvardhansahay
 */
public class result extends student implements internal, external{
    int iphy, ichem, imath, ephy, echem, emath;
    result() {      
        iphy = ichem = imath = ephy = echem = emath = 0;
    }
    public void get () {
        super.get();
        System.out.print("Enter internal marks in physics:\t");
        iphy = sc.nextInt();
        System.out.print("Enter internal marks in chemistry:\t");
        ichem = sc.nextInt();
        System.out.print("Enter internal marks in Mathematics:\t");
        imath = sc.nextInt();
        System.out.print("Enter external marks in physics:\t");
        ephy = sc.nextInt();
        System.out.print("Enter external marks in chemistry:\t");
        echem = sc.nextInt();
        System.out.print("Enter external marks in Mathematics:\t");
        emath = sc.nextInt();
    }
    
    public void put () {
        System.out.println("Enrollment number:\t" + Enrollment_No);
        System.out.println("Name:\t" + Name);
        System.out.println("Date of Birth:\t" + DOB);
        System.out.println("Total marks in physics:\t" + (iphy + ephy));
        System.out.println("Total marks in chemistry:\t" + (ichem + echem));
        System.out.println("Total marks in mathematics:\t" + (imath + emath));
        System.out.println("Gross total:\t" + ((iphy + ephy + ichem + echem + imath + emath))/3);
    }
}
