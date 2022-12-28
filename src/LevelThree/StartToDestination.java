package LevelThree;

import java.util.Scanner;

public class StartToDestination {
	public static void main(String[] args) {
		
		Scanner a= new Scanner(System.in);
		int sig;
		
		
		System.out.println( "enter the number of signal:");
		sig =a.nextInt();
		
		
		System.out.println("does the distance (y or n):");
		String Var =a.next();
		
		int[] dTime= new int[7];
		
		if(Var.equals("y")) {
			System.out.println("enter the distance between last signal:");
			int sameTime =a.nextInt();
			for(int i=0; i<= sig;i++) 
			{
				
				dTime[i]=sameTime;
			}
			
		}
		else {
			for(int i=0;i<sig; i++) {
			System.out.println("enetr the time of signal"+(i+1)+":");
			dTime[i] = a.nextInt();
			}
			System.out.print("Enter time to reach destination from signal #" + sig + " : ");
		      dTime[sig] = a.nextInt();
		}
		
		
		
		int [] Way=new int[7];
		
		System.out.println("does all signals are two way(y or n):");
		Var=a.next();
		
		
		if (Var.equals("n")) {
			for(int i=0;i<sig;i++) {
				System.out.println("enter the no of way#"+(i+1)+"(2-4):");
				Way[i]=a.nextInt();
			}
			
			}
		else {
			for (int i=0;i<sig;i++) {
				Way[i]=2;
			}
		}
		
		int signalTime;
		System.out.println("enter the signal time:");
		signalTime = a.nextInt();
		
		int duration =0;
		   for(int i = 0; i <=  sig; i++) {
			      duration = duration + dTime[i];
			      int waitingTime = 0;
			      
			      int currentSignal = (duration / signalTime);
			      
			      //System.out.println(duration);
			      
			      if(i<sig) {
			        if(currentSignal % Way[i] != 0) {
			          
			          int nextSignal = duration / signalTime;
			          while(nextSignal % Way[i] != 0) {
			            nextSignal++;
			          }
			          
			          waitingTime = (nextSignal * signalTime) - duration;

			          duration = duration + waitingTime;

			          //System.out.println(duration + " * " + waitingTime);          
			        }
			      }
			    }
			    
			    System.out.println("It takes "+ duration +" seconds to reach destination");
	}

}
