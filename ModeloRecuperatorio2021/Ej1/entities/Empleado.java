package entities;

import java.time.LocalDate;

public class Empleado {
	private Integer id;
	private String nombre;
	private LocalDate ingreso;
	private Double sueldoBase;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getIngreso() {
		return ingreso;
	}
	public void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}
	public Double getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(Double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public Double getSueldo() {
		return sueldoBase;
	}

}
