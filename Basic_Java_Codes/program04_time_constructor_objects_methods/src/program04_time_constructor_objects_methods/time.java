/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program04_time_constructor_objects_methods;
import java.util.*;
/**
 *
 * @author harshvardhansahay
 */
public class time {
    int day, hr, min, sec;
    
    time() {
        day = hr = min = sec = 0;
    }
    
    time(int day, int hr, int min, int sec) {
        this.day = day;
        this.hr = hr;
        this.min = min;
        this.sec = sec;
        standardize();
    }
    
    public final void standardize() {
        if(sec > 59) {
            min += sec / 60;
            sec %= 60;
        }
        if(min > 59) {
            hr += min / 60;
            min %= 60;
        }
        if(hr > 23) {
            day += hr / 24;
            hr %= 24;
        }
    }
    
    public void get() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter days:\t");
        day = sc.nextInt();
        System.out.print("Enter hours:\t");
        hr = sc.nextInt();
        System.out.print("Enter minutes:\t");
        min = sc.nextInt();
        System.out.print("Enter seconds:\t");
        sec = sc.nextInt();
        System.out.print("\n");
        standardize();
    }
    
    public void put() {
        System.out.println("Days:\t" + day);
        System.out.println("Hours:\t" + hr);
        System.out.println("Minutes:\t" + min);
        System.out.println("Seconds:\t" + sec);
    }
    
    public time add(time t) {
        time t1 = new time();
        t1.day = day +t.day;
        t1.hr = hr + t.hr;
        t1.min = min + t.min;
        t1.sec = sec + t.sec;
        t1.standardize();
        return t1;        
    }
}