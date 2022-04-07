package logica;

import java.util.Scanner;

import entidades.*;

public class Creador {
	
	public void cargaDatos(Scanner lector,Empleado emp) {	
		System.out.print("Ingrese el DNI:");
		emp.setDni(Integer.parseInt(lector.nextLine()));
		System.out.print("Ingrese el nombre:");
		emp.setNombre(lector.nextLine());
		System.out.print("Ingrese el apellido:");
		emp.setApellido(lector.nextLine());
		System.out.print("Ingrese el email:");
		emp.setEmail(lector.nextLine());
		
		
	}

	public Administrativo crearAdmin(Scanner lector) {
		Administrativo emp= new Administrativo();
		cargaDatos(lector, emp);
		System.out.print("Ingrese las horas extra:");
		emp.setHsExtra(Integer.parseInt(lector.nextLine()));
		System.out.print("Ingrese las horas del mes:");
		emp.setHsMes(Integer.parseInt(lector.nextLine()));
		return emp;
		
	}
	
	public Vendedor crearVend(Scanner lector) {
		Vendedor emp =new Vendedor();
		cargaDatos(lector, emp);
		System.out.print("Ingrese el porcentaje de comision:");
		emp.setPorcenComision(Double.parseDouble(lector.nextLine()));
		System.out.print("Ingrese el total de ventas:");
		emp.setTotalVentas(Integer.parseInt(lector.nextLine()));
		return emp;
		
	}

}
