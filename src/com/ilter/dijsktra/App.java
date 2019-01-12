package com.ilter.dijsktra;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = null;
		Philosopher[] philosophers = null;
		
		try {
			philosophers = new Philosopher[Constants.Number_of_Philosophers];
			Chopstick [] chopsticks= new Chopstick[Constants.Number_of_Chopsticks]; 
			
			for(int i=0 ; i<Constants.Number_of_Chopsticks; i++)
				chopsticks[i] = new Chopstick(i);
				
				executorService = Executors.newFixedThreadPool(Constants.Number_of_Philosophers);
				
				for(int i=0; i<Constants.Number_of_Philosophers;i++){
					philosophers[i] = new Philosopher (i,chopsticks[i],chopsticks[(i+1) % Constants.Number_of_Chopsticks]);
					executorService.execute(philosophers[i]);
				}
				Thread.sleep(Constants.Simulation_Running_Time);
			
				for(Philosopher p : philosophers){
					p.setFull(true);
				}
		} finally {
			executorService.shutdown();
			
			while(!executorService.isTerminated())
		Thread.sleep(1000);
			
			for(Philosopher p: philosophers)
		System.out.println(p + " eats" + p.getCounter());
		}
		
	}
	
}
