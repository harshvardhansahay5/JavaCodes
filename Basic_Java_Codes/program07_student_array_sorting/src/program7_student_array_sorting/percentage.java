/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program7_student_array_sorting;

/**
 *
 * @author harshvardhansahay
 */
final public class percentage extends Marks{
    double percentage;
    
    percentage () {
        percentage = 0;
    }
    
    public double getperc() {
        return super.getsum()/3;
    }
    
    public void get() {
        super.get();
        percentage = super.getsum()/3;
    }
    
    public void put() {
        super.put();
        System.out.println("Percentage:\t" + percentage);
    }
}
