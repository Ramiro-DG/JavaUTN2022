package entities;

import java.util.ArrayList;

public class Mecanico extends Empleado{
	private Double valorKm;
	private ArrayList<Vehiculo> vehiculos=new ArrayList<>();

	public Double getValorKm() {
		return valorKm;
	}

	public void setValorKm(Double valorKm) {
		this.valorKm = valorKm;
	}
	
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public Double getSueldo() {
		Double acum=super.getSueldo();
		for (Vehiculo vehiculo : vehiculos) {
			for (Viaje viaje : vehiculo.getViajesDelMes()) {
				acum+=(viaje.getKms()*valorKm);
			}
		}
		return acum;
	}
}
