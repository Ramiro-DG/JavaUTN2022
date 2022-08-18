package ej1;

import java.util.LinkedList;

public class Client {
	private String firstName;
	private String lastName;
	private LinkedList<Event> eventosContratados;
	
	public Client() {
		eventosContratados=new LinkedList<>();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LinkedList<Event> getEventosContratados() {
		return eventosContratados;
	}
	public void setEventosContratados(LinkedList<Event> eventosContratados) {
		this.eventosContratados = eventosContratados;
	}
	
	public void addEvent(Event e) {
		eventosContratados.add(e);
	}

}
