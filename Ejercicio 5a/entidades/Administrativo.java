package entidades;

public class Administrativo extends Empleado{
	int hsExtra;
	int hsMes;
	
	//Getters y Setters
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMes() {
		return hsMes;
	}
	public void setHsMes(int hsMes) {
		this.hsMes = hsMes;
	}
	public double getSueldo() {
		return sueldoBase *((hsExtra*1.5)+hsMes)/hsMes;
	}

}
