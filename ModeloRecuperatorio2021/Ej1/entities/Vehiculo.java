package entities;

import java.util.ArrayList;

public class Vehiculo {
	private String patente; 
	private String marca;
	private String modelo;
	private ArrayList<Viaje> viajes =new ArrayList<>();
	private Mecanico mecanico;
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void addViaje(Viaje v) {
		viajes.add(v);
	}
	
	public ArrayList<Viaje> getViajesDelMes() {
		return viajes;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

}
