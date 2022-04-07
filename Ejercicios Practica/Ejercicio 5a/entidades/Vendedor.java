package entidades;

public class Vendedor extends Empleado{
	private double porcenComision;
	private int totalVentas;
	
	//Getters y Setters
	public double getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(double d) {
		this.porcenComision = d;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	public double getSueldo() {
		return (sueldoBase + (porcenComision*totalVentas/100));
	}
}
