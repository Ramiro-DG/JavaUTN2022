package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	
	public Login() {
		dp=new DataPersona();
		dr=new DataRol();
	}
	
	public Persona validate(Persona p) {
		Persona sel=dp.getByUser(p);
		return (sel.isHabilitado()==false?null:sel);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public LinkedList<Persona> getAllByLastname(Persona personaIn){
		return dp.getAllByLastname(personaIn);
	}
	
	public Persona newPersona(Persona personaIn) {
		return dp.add(personaIn);
	}
	
	public Persona update(Persona p) {
		dr.removeAll(p);
		return dp.update(p);
	}
	
	public void deleteFisico(Persona p) {
		dp.deleteFisico(p);
	}
	
	public void deleteLogico(Persona p) {
		dp.deleteLogico(p);
	}
	
	public Rol getById(Rol r) {
		return dr.getById(r);
		
	}

	public void saveRolPersona(Rol r, Persona p) {
		dr.saveRolPersona(dr.getById(r), p);
		
	}
	
	public void setRoles(Persona p) {
		dr.setRoles(p);		
	}
}
