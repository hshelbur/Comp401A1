package a1jedi;

import java.util.Scanner;

public class A1Jedi {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		double midterm1_total = 0;
		double midterm2_total = 0;
		double final_total = 0;
		double midterm1_average = 0;
		double midterm2_average = 0;
		double final_average = 0;
		double midterm1_std_deviation = 0;
		double midterm2_std_deviation = 0;
		double final_std_deviation = 0;
		double assignment_points_possible = 0;
		int a = 0, a_minus = 0, b_plus = 0, b = 0, b_minus = 0, c_plus = 0, c = 0, c_minus = 0, d_plus = 0, d = 0, f = 0;
		
		
		int number_of_assignments = s.nextInt();
		
		
		
		for (int n = 0; n < number_of_assignments; n++) {
			assignment_points_possible = assignment_points_possible + s.nextInt();
		}
		
		int number_of_students = s.nextInt();
		double[] assignment_grade_array = new double [number_of_assignments];
		double[] recitations_grades_array = new double [number_of_students];
		double[] midterm_1_grades_array = new double [number_of_students];
		double[] midterm_2_grades_array = new double [number_of_students];
		double[] final_grades_array = new double [number_of_students];
		String[] students_array = new String [number_of_students];

		
		for (int n = 0; n < number_of_students; n++) {
			
			double assignment_points_earned = 0;
			double assignment_percent = 0;
			double recitations_attended = 0;
			double recitations_percent = 0;
			
			students_array[n] = s.next() + " " + s.next();
			
			recitations_attended = s.nextDouble();
			recitations_percent = recitations_attended / 15;
			recitations_grades_array[n] = percent_mapped(recitations_percent);
			
			
			
			for(int x = 0; x < number_of_assignments; x++){
				assignment_points_earned = assignment_points_earned + s.nextDouble();
			}
			
			assignment_percent = assignment_points_earned / assignment_points_possible;
			
			assignment_grade_array[n] = percent_mapped(assignment_percent);
			
			midterm_1_grades_array[n] = s.nextDouble();
			midterm_2_grades_array[n] = s.nextDouble();			
			final_grades_array[n] = s.nextDouble();
			

			}
		
		
		for(int i = 0; i < number_of_students; i++){
			midterm1_total = midterm1_total + midterm_1_grades_array[i];
			midterm2_total = midterm2_total + midterm_2_grades_array[i];
			final_total = final_total + final_grades_array[i];
		}

		midterm1_average = midterm1_total / number_of_students;
		midterm2_average = midterm2_total / number_of_students;
		final_average = final_total / number_of_students;

		midterm1_std_deviation = std_deviation(midterm_1_grades_array, midterm1_average);
		midterm2_std_deviation = std_deviation(midterm_2_grades_array, midterm2_average);
		final_std_deviation = std_deviation(final_grades_array, final_average);
		
		for(int i=0; i < number_of_students; i++){
			String letter_grade = null;
			double normalized_midterm1_grade = (midterm_1_grades_array[i] - midterm1_average) / midterm1_std_deviation;
			double normalized_midterm2_grade = (midterm_2_grades_array[i] - midterm2_average) / midterm2_std_deviation;
			double normalized_final_grade = (final_grades_array[i] - final_average) / final_std_deviation;
			double curved_midterm1 = 0;
			double curved_midterm2 = 0;
			double curved_final = 0;
			
			curved_midterm1 = normalized_mapped(normalized_midterm1_grade);
			curved_midterm2 = normalized_mapped(normalized_midterm2_grade);
			curved_final = normalized_mapped(normalized_final_grade);
			
			letter_grade = letter_grade(weighted_average(recitations_grades_array[i], assignment_grade_array[i], curved_midterm1, curved_midterm2, curved_final));
			
			if(letter_grade.equals("A")){
				a = a +1;
			}else if(letter_grade.equals("A-")){
				a_minus = a_minus + 1;
			}else if(letter_grade.equals("B+")){
				b_plus = b_plus + 1;
			}else if(letter_grade.equals("B")){
				b = b +1;
			}else if(letter_grade.equals("B-")){
				b_minus = b_minus + 1;
			}else if(letter_grade.equals("C+")){
				c_plus = c_plus + 1;
			}else if(letter_grade.equals("C")){
				c = c + 1;
			}else if(letter_grade.equals("C-")){
				c_minus = c_minus + 1;
			}else if(letter_grade.equals("D+")){
				d_plus = d_plus + 1;
			}else if(letter_grade.equals("D")){
				d = d + 1;
			}else{
				f = f +1;
			}
			
		}
		

		System.out.println("A : " + a + "\nA-: " + a_minus + "\nB+: " + b_plus + "\nB : " + b + "\nB-: " + b_minus + "\nC+: " + c_plus + "\nC : " + c + "\nC-: " + c_minus + "\nD+: " + d_plus + "\nD : " + d + "\nF : " + f);

		
	}
	
	
	
	static double std_deviation(double[] array, double average){
		double std_deviation = 0;
		double total = 0;
		double total_average = 0;
		for(int i=0; i < array.length; i++){
			total = total + ((array[i] - average) * (array[i] - average));
		}
		
		total_average = total / array.length;
		
		std_deviation = Math.sqrt(total_average);
		
		return std_deviation;
	}
	
	static double normalized_mapped(double normalized_grade){
		if(normalized_grade >= 1){
			return 4;
		}else if(normalized_grade >= -1){
			return normalized_grade + 3;
		}else if(normalized_grade >= -2){
			return (normalized_grade+2) * 2;
		}else {
			return 0;
		}
	}

	static double percent_mapped(double percent){

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


