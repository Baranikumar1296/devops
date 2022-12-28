package Guru;

import java.util.Scanner;

public class gm {
  
  public static void main(String[] args) {
    int signals;
    int[] distanceTime = new int[10];
    int[] paths = new int[10];
    int signalTime;
    int duration = 0;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of signals : ");
    signals = sc.nextInt();
    
    
    System.out.print("Does the signals have same time difference (y or n) : ");
    String check = sc.next();
    
    
    //get time difference between each signals
    if(check.equals("y")) {
      System.out.print("Ener time difference between each signals including last signal to destination : ");
      int sameTime = sc.nextInt();
      
      for(int i = 0; i <= signals; i++) {
        distanceTime[i] = sameTime;
      }
    } else {
      for(int i = 0; i < signals; i++) {
        System.out.print("Enter time to signal #" + (i+1) + ": ");
        distanceTime[i] = sc.nextInt();
      }
      System.out.print("Enter time to reach destination from signal #" + signals + " : ");
      distanceTime[signals] = sc.nextInt();
    }
    
    
    System.out.print("Does all signals are two ways (y or n) : ");
    check = sc.next();
    
    
    //get number of paths in each signal
    if(check.equals("n")) {
      for(int i = 0; i < signals; i++) {
        System.out.print("Enter number of paths at signal #" + (i+1) + " (2-4) : ");
        paths[i] = sc.nextInt();
      }
    } else {
      for(int i = 0; i < signals; i++) {
        paths[i] = 2;
      }
    }
    
    
    System.out.print("Enter the signal time : ");
    signalTime = sc.nextInt();
    
    
    for(int i = 0; i <= signals; i++) {
      duration = duration + distanceTime[i];
      int waitingTime = 0;
      
      int currentSignal = (duration / signalTime);
      
      //System.out.println(duration);
      
      if(i<signals) {
        if(currentSignal % paths[i] != 0) {
          
          int nextSignal = duration / signalTime;
          while(nextSignal % paths[i] != 0) {
            nextSignal++;
          }
          
          waitingTime = (nextSignal * signalTime) - duration;

          duration = duration + waitingTime;

          //System.out.println(duration + " * " + waitingTime);          
        }
      }
    }
    System.out.println();
    System.out.println("It takes "+ duration +" seconds to reach destination");
  }
}