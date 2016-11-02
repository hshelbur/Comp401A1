package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		
		process(s);
	}
	
	public static void process(Scanner s) {
		
		int number_of_students = s.nextInt();
		
		for (int n = 0; n < number_of_students; n++) {
		
			String first_name = s.next();
			String last_name = s.next();
			double ag = s.nextDouble();
			double rg = s.nextDouble();
			double m1 = s.nextDouble();
			double m2 = s.nextDouble();			
			double fe = s.nextDouble();
			
			double avg = weighted_average(ag, rg, m1, m2, fe);
			
			char first_initial = first_name.charAt(0);
			
			String lg = letter_grade(avg);
			
			System.out.println(first_initial + ". " + last_name + " " + lg);
		}
		
	}
		
		static double weighted_average(double ag, double rg, double m1, double m2, double fe) {
			
			double wa = (ag*.4)+(rg*.1)+(m1*.15)+(m2*.15)+(fe*.2);
			
			return wa; 
	}
		static String letter_grade(double avg){
			
			if(avg>=3.85){
				return "A";
			}else if(avg>=3.5){
				return "A-";
			}else if(avg>=3.15){
				return "B+";
			}else if(avg>=2.85){
				return "B";
			}else if(avg>=2.5){
				return "B-";
			}else if(avg>=2.15){
				return "C+";
			}else if(avg>=1.85){
				return "C";
			}else if(avg>=1.5){
				return "C-";
			}else if(avg>=1.15){
				return "D+";
			}else if(avg>=0.85){
				return "D";
			}else{
				return "F";
			}
			

		}
	}	

