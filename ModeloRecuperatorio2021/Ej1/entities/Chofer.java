package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Chofer extends Empleado{
	private String carnet;
	private LocalDate proximoVencimiento;
	private Double cantViajesPremio;
	private Double premio;
	private ArrayList<Viaje> viajes=new ArrayList<>();
	
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public LocalDate getProximoVencimiento() {
		return proximoVencimiento;
	}
	public void setProximoVencimiento(LocalDate proximoVencimiento) {
		this.proximoVencimiento = proximoVencimiento;
	}
	public Double getCantViajesPremio() {
		return cantViajesPremio;
	}
	public void setCantViajesPremio(Double cantViajesPremio) {
		this.cantViajesPremio = cantViajesPremio;
	}
	public Double getPremio() {
		return premio;
	}
	public void setPremio(Double premio) {
		this.premio = premio;
	}
	public ArrayList<Viaje> getViajesDelMes() {
		return viajes;
	}
	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	@Override
	public Double getSueldo() {
		Double acum=super.getSueldo();
		if(viajes.size()>=cantViajesPremio) {
			acum+=premio;
		}
		return acum;
	}
	

}
