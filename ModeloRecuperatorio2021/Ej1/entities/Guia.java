package entities;

import java.util.ArrayList;

public class Guia extends Empleado {
	private String disponibilidad;
	private Double valorHora;
	private ArrayList<Viaje> viajes=new ArrayList<>();
	private ArrayList<Idioma> idiomas=new ArrayList<>();
	
	public ArrayList<Idioma> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(ArrayList<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
	public ArrayList<Viaje> getViajesDelMes() {
		return viajes;
	}
	public void addViaje(Viaje viaje) {
		viajes.add(viaje);
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Double getValorHora() {
		return valorHora;
	}
	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}
	
	@Override
	public Double getSueldo() {
		Double acum=super.getSueldo();
		for (Viaje viaje : getViajesDelMes()) {
			acum+=(viaje.getDuracionHs()*valorHora);
		}
		for (Idioma idioma : idiomas) {
			acum+=idioma.getAdicionalActual();
		}
		return acum;		
	}
	
}
