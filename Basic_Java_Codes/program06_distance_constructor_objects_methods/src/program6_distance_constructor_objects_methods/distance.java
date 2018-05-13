/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program6_distance_constructor_objects_methods;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class distance {
    double f, i;
    
    distance() {
        f = i = 0;
    }
    
    distance(double f, double i) {
        this.f = f;
        this.i = i;
        standardize();
    }
    
    public void get() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter feets:\t");
        f = sc.nextInt();
        System.out.print("Enter inches:\t");
        i = sc.nextInt();
        standardize();
    }

    private void standardize() {
        if(i > 11) {
            f += i / 12;
            i %= 12;
        }
    }
    
    public distance add(distance d) {
        distance d1 = new distance();
        d1.f = f + d.f;
        d1.i = i + d.i;
        d1.standardize();
        return d1;
    }
    
    public distance sub(distance d) {
        distance d1 = new distance();
        d1.i = i - d.i;
        d1.f = f - d.f;
        if(d1.i < 0 && d1.f >0) {
            d1.i += 12;
            --d1.f;
        }
        if(d1.f < 0 && d1.i >0) {
            d1.f += 1;
            d1.i -= 12;
        }
        return d1;
    }
    
    public void display() {
        System.out.print(f + "'" + i + "\"");
    }
}
