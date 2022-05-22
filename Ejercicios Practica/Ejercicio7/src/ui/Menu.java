package ui;


import java.util.LinkedList;
import java.util.Scanner;

import data.DataRol;
import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();
	DataRol dr=new DataRol();
	
	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		if(p!=null) {
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		}
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(findDocument());
			break;
		case "search":
			for (Persona p : findLastname()) {
				System.out.println(p);
			}
			break;
		case "new":
			System.out.println(newPersona());
			break;
		case "edit":
			update();
			break;
		case "delete":
			delete();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1	
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		
		System.out.println("delete\t\tborra por tipo y nro de documento");		
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona findDocument() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	
	private LinkedList<Persona> findLastname() {
		System.out.println();
		Persona p=new Persona();
		System.out.print("Apellido persona: ");
		p.setApellido(s.nextLine());
		
		return ctrlLogin.getAllByLastname(p);
	}

	private Persona newPersona() {
		Persona p =new Persona();
		Documento d=new Documento();
		Rol r=new Rol();
		int idRol=1;
		
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());
		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		System.out.println("Nombre: ");
		p.setNombre(s.nextLine());
		System.out.println("Apellido: ");
		p.setApellido(s.nextLine());	
		System.out.println("Email: ");
		p.setEmail(s.nextLine());
		System.out.println("Telefono: ");
		p.setTel(s.nextLine());
		System.out.println("Habilitado: ");	
		p.setHabilitado((Integer.parseInt(s.nextLine())==1?true:false));
		System.out.println("Password: ");
		p.setPassword(s.nextLine());
		p=ctrlLogin.newPersona(p);
		
		System.out.println("Listado de Roles: ");
		System.out.println(dr.getAll());		
		while(idRol!=0) {
			System.out.println("Id Rol (0 para salir): ");
			idRol=Integer.parseInt(s.nextLine());
			if(idRol!=0) {
			r.setId(idRol);
			ctrlLogin.saveRolPersona(r,p);}
		}
		ctrlLogin.setRoles(p);
		return p;
	}
	
	private Persona update() {
		Persona p=new Persona();
		Documento d=new Documento();
		int idRol=1;
		Rol r=new Rol();
		
		p.setDocumento(d);
		System.out.println("INGRESAR DOCUMENTO PARA BUSCAR:");
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());
		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());		
		p=ctrlLogin.getByDocumento(p);
		
		System.out.println("MODIFICAR DATOS:");
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());
		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());	
		System.out.println("Nombre: ");
		p.setNombre(s.nextLine());
		System.out.println("Apellido: ");
		p.setApellido(s.nextLine());	
		System.out.println("Email: ");
		p.setEmail(s.nextLine());
		System.out.println("Telefono: ");
		p.setTel(s.nextLine());
		System.out.println("Habilitado: ");
		p.setHabilitado(Boolean.parseBoolean(s.nextLine()));
		System.out.println("Password: ");
		p.setPassword(s.nextLine());
		ctrlLogin.update(p);
		
		System.out.println("Listado de Roles: ");
		System.out.println(dr.getAll());		
		while(idRol!=0) {
			System.out.println("Id Rol (0 para salir): ");
			idRol=Integer.parseInt(s.nextLine());
			if(idRol!=0) {
				r.setId(idRol);
				if(!p.hasRol(r)) {
				ctrlLogin.saveRolPersona(r,p);
				ctrlLogin.setRoles(p);}
			}
		}
		
		return p;
	}
	
	private void delete() {
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());
		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		p=ctrlLogin.getByDocumento(p);

		System.out.println("�Desea realizar un borrado logico o fisico?");
		switch (s.nextLine()) {
		case "logico":
			ctrlLogin.deleteLogico(p);
			break;
		case "fisico":
			ctrlLogin.deleteFisico(p);
			break;
		default:
			break;
		}
		
	}
}
