package entidades;

public class Empleado {
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	static double sueldoBase=50;
	
	//Getters y Setters
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSueldo() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		Empleado.sueldoBase = sueldoBase;
	}

}
