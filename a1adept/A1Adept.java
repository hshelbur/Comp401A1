package a1adept;

import java.util.Scanner;

public class A1Adept {
	
	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	
	public static void process(Scanner s) {
		
		double tpp = 0;
		
		int number_of_assignments = s.nextInt();
		
		for (int n = 0; n < number_of_assignments; n++) {
			double points = s.nextDouble();
			tpp = tpp + points;
		}
		
		int number_of_students = s.nextInt();
		
		for (int n = 0; n < number_of_students; n++) {
		
			double tpe = 0;
			String first_name = s.next();
			String last_name = s.next();
			double rAttended = s.nextDouble();
			
			for(int c = 0; c < number_of_assignments; c++){
				double points = s.nextDouble();
				tpe = tpe + points;
			}
			
			double rg = recitation_grade(rAttended);
			double ag = assignment_grade(tpe, tpp);
			double m1 = s.nextDouble();
			double m2 = s.nextDouble();			
			double fe = s.nextDouble();
			
			double avg = weighted_average(rg, ag, m1, m2, fe);
			
			char first_initial = first_name.charAt(0);
			
			String lg = letter_grade(avg);
			
			System.out.println(first_initial + ". " + last_name + " " + lg);

		}
		
	}
	
	static double recitation_grade(double rAttended){
		double r_percent = rAttended / 15;
		if(r_percent >= .95){
			return 4;
		}else if(r_percent >= .7){
			double p_mapped = 0;
			p_mapped = (((r_percent - .7) / (.25)) * (2.5)) + 1.5;
			return p_mapped;
		}else if(r_percent >= .4){
			double p_mapped = 0;
			p_mapped = (((r_percent - .4) / (.3)) * (1.5));
			return p_mapped;
		}else {
			return 0;
		}
	}
	
	static double assignment_grade(double tpe, double tpp){
		double percent = tpe/tpp;
		if(percent >= .95){
			return 4;
		}else if(percent >= .7){
			double p_mapped = 0;
			p_mapped = (((percent - .7) / (.25)) * (2.5)) + 1.5;
			return p_mapped;
		}else if(percent >= .4){
			double p_mapped = 0;
			p_mapped = (((percent - .4) / (.3)) * (1.5));
			return p_mapped;
		}else {
			return 0;
		}
	}
		
		static double weighted_average(double rg, double ag, double m1, double m2, double fe) {
			
			double wa = (rg*.1)+(ag*.4)+(m1*.15)+(m2*.15)+(fe*.2);
			
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


