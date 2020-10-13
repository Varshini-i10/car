package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test{

     public static void main(String []args){
    
            String path=args[0];
            
            // Number of outputs displayed 
            int n=Integer.valueOf(args[1]);
            String cityname=args[2];
            List<String> each_line = new ArrayList<>();
            File file = new File(path);
        	try{
        	    Scanner scanner = new Scanner(file);
        	    while (scanner.hasNextLine()) {
        	        String line = scanner.nextLine();
        	        each_line.add(line);
        	    }
        	    scanner.close();
            }
            catch(FileNotFoundException e) { 
            	   System.out.println("file path not found");
	        }
        	each_line.remove(0);
        	int size=each_line.size();
            List<String> car=new ArrayList<>(size);
            List<String> cities=new ArrayList<>(size);
            List<Double> HorsePower=new ArrayList<>(size);
        try {
            each_line.forEach(line->{
                String[] split=line.split(",");
                car.add(split[0]);
                cities.add(split[1]);
                HorsePower.add(Double.valueOf(split[2]));
            });
        }
        catch(Exception e){
        	System.out.println("Please give the details in Correct format - {Car name, city name ,HorsePower}" );
        }
            
        try {
        double average=0;	
        int count=0;
        for(int i=0;i<size;i++){
            if(cities.get(i).contains(cityname)){
            	average+= HorsePower.get(i);
                count++;
                
            }
        }
        average=(average)/count;
        System.out.println("With average HorsePower: "+String.format("%.2f",average)+"  in the City  " +cityname );
        for(int i =0;i<size&&n>0  ;i++){
            if( HorsePower.get(i)>average && cities.get(i).contains(cityname)){
                System.out.println(each_line.get(i)+"   ");
                n--;
            }
        }  
        
        }
        catch(ArithmeticException e)
        {
        	System.out.println("No data found for the origin, Pleasse re-enter the details");
        }
        
     }
}
