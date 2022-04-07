package logica5b;
import java.util.ArrayList;
import java.util.Scanner;
import entidades.*;
import logica.Creador;


public class Principal {

	public static void main(String[] args) {
		final int max =3;
		int opc;
		ArrayList<Empleado> arr = new ArrayList<>();
		Scanner lector = new Scanner(System.in);
		Creador factory = new Creador();
		
		for (int i=0;i<max;i++) {
			System.out.println("1-Administrativo 2-Vendedor");
			opc=Integer.parseInt(lector.nextLine());
			
			switch (opc) {
			case 1:
				arr.add(factory.crearAdmin(lector));
				break;
			case 2:
				arr.add(factory.crearVend(lector));
				break;

			default:
				break;
			}
			
		}	
		
		for (Empleado empleado : arr) {
			System.out.println(empleado.getNombre()+" "+empleado.getApellido()+" "+empleado.getDni()+" "+empleado.getSueldo());
		

	}

	}}




