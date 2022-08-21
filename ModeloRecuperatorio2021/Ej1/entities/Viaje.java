package entities;

import java.time.LocalDate;

public class Viaje {
	private Integer id;
	private LocalDate fecha;
	private Double duracionHs;
	private Double kms;
	private Integer capacidad;
	private Vehiculo vehiculo;
	private Guia guia;
	private Chofer chofer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Double getDuracionHs() {
		return duracionHs;
	}
	public void setDuracionHs(Double duracionHs) {
		this.duracionHs = duracionHs;
	}
	public Double getKms() {
		return kms;
	}
	public void setKms(Double kms) {
		this.kms = kms;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	

}
