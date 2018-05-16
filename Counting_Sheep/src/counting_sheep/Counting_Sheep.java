/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counting_sheep;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harshvardhansahay
 */
public class Counting_Sheep implements Runnable {
    
    public boolean running = false;
    
    int num, check;

    public Counting_Sheep(int n) {
        num = n;
        check = 0;
        Thread thread = new Thread(this);  
        thread.start();
    }
    
    public static void main(String[] args) {
        
        List<Counting_Sheep> num = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases:\t");
        
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++){
            num.add(new Counting_Sheep(sc.nextInt()));
        }

        for (Counting_Sheep cs : num) {
            while (cs.running) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Counting_Sheep.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public int checkstatus(){
        return check;
    }
    
    public void update_check(){
        ++check;
    }

    public void run(){
        try{
             for(int i = 0; i < 10; ++i){
                 
             }
        }
        catch (Exception e){
            System.out.println ("Thread " + Thread.currentThread().getId() + " was running");
            Thread.currentThread().interrupt();
            System.out.println ("Exception is caught");
        }
    }
    
}


class number extends Counting_Sheep implements Runnable{

    public number(int n) {
        
    }
     
     
    
    public void run(){
        try{
             for(int i = 0; i < 10; ++i){
                 
             }
        }
        catch (Exception e){
            System.out.println ("Thread " + Thread.currentThread().getId() + " was running");
            System.out.println ("Exception is caught");
        }
    }
 }

class cases extends Thread
{
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                  Thread.currentThread().getId() +
                  " is running");
 
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}






//public class Worker implements Runnable   
//{  
//  public boolean running = false;  
//    
//  public Worker ()  
//  {  
//    Thread thread = new Thread(this);  
//    thread.start();  
//  }  
//    
//  public static void main (String[] args) throws InterruptedException  
//  {  
//    List<Worker> workers = new ArrayList<Worker>();  
//      
//    System.out.println("This is currently running on the main thread, " +  
//        "the id is: " + Thread.currentThread().getId());  
//  
//    Date start = new Date();  
//  
//    // start 5 workers  
//    for (int i=0; i<5; i++)  
//    {  
//      workers.add(new Worker());   
//    }  
//      
//    // We must force the main thread to wait for all the workers  
//    //  to finish their work before we check to see how long it  
//    //  took to complete  
//    for (Worker worker : workers)  
//    {  
//      while (worker.running)  
//      {  
//        Thread.sleep(100);  
//      }  
//    }  
//      
//    Date end = new Date();  
//      
//    long difference = end.getTime() - start.getTime();  
//      
//    System.out.println ("This whole process took: " + difference/1000 + " seconds.");  
//  }  
//    
//  @Override  
//  public void run()   
//  {  
//    this.running = true;  
//    System.out.println("This is currently running on a separate thread, " +  
//        "the id is: " + Thread.currentThread().getId());  
//      
//    try   
//    {  
//      // this will pause this spawned thread for 5 seconds  
//      //  (5000 is the number of milliseconds to pause)  
//      // Also, the Thread.sleep() method throws an InterruptedException  
//      //  so we must "handle" this possible exception, that's why I've  
//      //  wrapped the sleep() method with a try/catch block  
//      Thread.sleep(5000);  
//    }   
//    catch (InterruptedException e)   
//    {  
//      // As user Bernd points out in the comments section below, you should  
//      //  never swallow an InterruptedException.  
//      Thread.currentThread().interrupt();  
//    }  
//    this.running = false;  
//  }  
//}  