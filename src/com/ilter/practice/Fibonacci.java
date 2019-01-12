package com.ilter.practice;

public class Fibonacci {


	public static int x=15;
	
	public static void main(String[] args) {
	
	double[] fiboarray = new double[x];
	fiboarray[0] = 0;
	fiboarray[1] = 1;
	
		if (x==0){
			System.out.println("0");
		}
		
		else if(x != 0){
			for(int i=0;i<x-2;i++){
				
				fiboarray[i+2] = fiboarray[i] + fiboarray[i+1];
			}
		}
		
		for(int j=0; j<x;j++){
			System.out.println(fiboarray[j]);
		}

	}

}
