package ej1;

public class Mein {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Event e=new Event();
		Service s1=new Service();
		s1.setCost(2352.45);
		e.addService(s1);
		System.out.println("Evento padre y el costo de servicios:");
		System.out.println(e.getOverallCost());
		
		Menu m=new Menu();
		m.setQuantity(200);
		m.setUnitCost(5.0);
		Catering c = new Catering();
		c.addMenu(m);
		c.addService(s1);
		System.out.println("Evento hija y el costo de servicios:");
		System.out.println(c.getOverallCost());
	}

}
