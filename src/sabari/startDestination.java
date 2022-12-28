package sabari;

import java.util.Scanner;

public class startDestination {

	public static void main(String[]args) {
		
		Scanner a = new Scanner(System.in);
		
		int sig;
		 System.out.println("Enter the nubmer of signals:");
		 sig = a.nextInt();
		 
		 int [] dTime = new int[7];
		 System.out.println("does the signal is same time different (y or n):");
		 String Ver =a.next();
		 
		 if (Ver.equals("y")) {
			 System.out.println("enter the different time of last signal ");
			 int sameTime = a.nextInt();
			 for (int i=0 ; i<= sig ; i++) {
				 dTime[i]=sameTime;
			 }
		 }
		 
		 else {
			 for (int i=0;i<sig;i++) {
				 System.out.println("enter the signal #"+(i+1)+":");
				 dTime[i]=a.nextInt();
			 }
			 System.out.println("enter the signal of destination from #"+sig+":");
			 dTime[sig]=a.nextInt();
			 
		 }
		 
		 int [] Way =new int [7];
		 System.out.println("does all signal are two ways (y or n):");
		 Ver =a.next();
		 
		 if (Ver.equals("n")) {
			 for(int i=0;i<sig;i++) {
				 System.out.println("enter the number of path signal#"+(i+1)+"(2-4):");
				 Way[i]=a.nextInt();
			 }
		 }
		 
		 else {
			 for(int i=0;i<sig;i++) {
				 Way[i]=2;
			 }
		 }
		 
		 int signalTime;
		 
		 System.out.println("enter the signal time");
		 signalTime =a.nextInt();
		 
		int duration = 0;
		 
		 for (int i=0;i<= sig;i++) {
			 duration=duration+dTime[i];
			 int wTime=0;
			 
			 int currentTime= (duration/signalTime);
			 
			 if(i<sig) {
				 if(currentTime % Way[i] !=0) {
					 int nextsignal = duration/signalTime;
					 while(nextsignal % Way[i] !=0) {
						 nextsignal ++;
					 }
					 
					 wTime = (nextsignal * signalTime) - duration;
					 
					 duration = duration + wTime;
					 
				 }
			 }
			 
		 }
		 
		 System.out.println("it taken "+duration+" seconds to reach the destination:");
		
	}
}
