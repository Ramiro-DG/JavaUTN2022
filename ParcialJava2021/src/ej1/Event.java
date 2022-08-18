package ej1;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Event {
	private LocalDateTime eventDate;
	private String location;
	LinkedList<Service> serviciosContratados;
	
	
	public Event() {
		serviciosContratados=new LinkedList<>();
	}
	
	public LocalDateTime getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public LinkedList<Service> getServiciosContratados() {
		return serviciosContratados;
	}

	public void setServiciosContratados(LinkedList<Service> serviciosContratados) {
		this.serviciosContratados = serviciosContratados;
	}

	public Double getOverallCost(){
		Double acum=0.0;
		for (Service service : serviciosContratados) {
			acum+=service.getCost();
		}
		return acum;
	}
	
	public void addService(Service s) {
		serviciosContratados.add(s);
	}
	

}
