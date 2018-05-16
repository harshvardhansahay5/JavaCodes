/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program05_complex_number_constructor_objects_methods;
import java.util. *;
/**
 *
 * @author harshvardhansahay
 */
public class complex_number {
    double r, i;
    
    complex_number() {
        r = i = 0;
    }
    
    complex_number(double r, double i) {
        this.r = r;
        this.i = i;
    }
    
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the REAL PART :\t");
        r = sc.nextDouble();
        System.out.print("Enter the IMAGINARY PART :\t");
        i = sc.nextDouble();
    }
    
    public complex_number add(complex_number c) {
        complex_number c1 = new complex_number();
        c1.r = r + c.r;
        c1.i = i + c.i;
        return c1;
    }
    
    public complex_number sub(complex_number c) {
        complex_number c1 = new complex_number();
        c1.r = r - c.r;
        c1.i = i - c.i;
        return c1;
    }
    
    public complex_number multi(complex_number c) {
        complex_number c1 = new complex_number();
        c1.r = (r * c.r) - (i * c.i);
        c1.i = (i * c.r) + (i * c.i);
        return c1;
    }
    
    public complex_number divi(complex_number c) {
        complex_number c1 = new complex_number();
        c1.r = ((r * c.r) + (i * c.i)) / ((c.r * c.r) + (c.i * c.i));
        c1.i = ((i * c.r) - (r * c.i)) / ((c.r * c.r) + (c.i * c.i));
        return c1;
    }
    
    public void display() {
        System.out.print(r + " + " + "i" + i);
    }
}