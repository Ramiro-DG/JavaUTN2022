package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
		ArrayList<String> names=new ArrayList<String>();
		names.add("Ramiro");
		names.add("Pablo Eduardo");
		names.add("D os");
		for(int i=1;i<=7;i++) {
		System.out.println(i+": "+m.cantLargas(names, i));
		}
	}

	public int cantLargas(ArrayList<String> listaNombres, int tamanio) {
		Integer cant=0;
		for (String string : listaNombres) {
			if((string.replace(" ", "").length())>tamanio) {
				cant++;
			}
		}
		return cant;
	}
	
}
