package ej4;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	final static int max = 2;

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<>();
		Scanner lector = new Scanner(System.in);
		
		
		for (int i = 0; i < max; i++) {
			if(arr.size()<20) {
			System.out.println("Ingrese el numero index ["+i+"]: ");
				arr.add(Integer.parseInt(lector.nextLine()));	
			}			
		}
		lector.close();
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}

}
