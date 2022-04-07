package logica;

import java.util.Scanner;
import entidades.*;


public class Principal {
	
	public static void main(String[] args) {
		final int max =2;
		int opc;
		Empleado[] arr = new Empleado[max];
		Scanner lector = new Scanner(System.in);
		Creador factory = new Creador();
		
		for (int i=0;i<arr.length;i++) {
			System.out.println("1-Administrativo 2-Vendedor");
			opc=Integer.parseInt(lector.nextLine());
			
			switch (opc) {
			case 1:
				arr[i]=factory.crearAdmin(lector);
				break;
			case 2:
				arr[i]=factory.crearVend(lector);
				break;

			default:
				break;
			}

		}	
		
		for (Empleado empleado : arr) {
			System.out.println(empleado.getNombre()+" "+empleado.getApellido()+" "+empleado.getDni()+" "+empleado.getSueldo());
		}
	}
}
