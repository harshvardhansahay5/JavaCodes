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
public class Marks extends student_details {
    double phy, chem, math;
    
    Marks() {
        phy = chem = math = 0;
    }
    public void get() {
        super.get();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the marks in physics:\t");
        phy = sc.nextDouble();
        System.out.print("Enter the marks in chemistry:\t");
        chem = sc.nextDouble();
        System.out.print("Enter the marks in mathematics:\t");
        math = sc.nextDouble();
    }
    
    public double getsum() {
        return phy + chem + math;
    }
    
    public double getperc() {
        return 0;
    }
    
    public void put() {
        super.put();
        System.out.println("Physics:\t" + phy);
        System.out.println("Chemistry:\t" + chem);
        System.out.println("Mathematics:\t" + math);
    }
}