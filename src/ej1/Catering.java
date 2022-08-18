package ej1;

import java.util.LinkedList;

public class Catering extends Event{
	private Double fixedCost;
	LinkedList<Menu> menues;
	
	public Catering() {
		menues=new LinkedList<>();
	}
	
	public Double getFixedCost() {
		return fixedCost;
	}
	public void setFixedCost(Double fixedCost) {
		this.fixedCost = fixedCost;
	}
	public LinkedList<Menu> getMenues() {
		return menues;
	}
	public void setMenues(LinkedList<Menu> menues) {
		this.menues = menues;
	}
	
	public void addMenu(Menu m) {
		menues.add(m);
	}
	
	@Override
	public Double getOverallCost(){
		Double acum=super.getOverallCost();
		for (Menu menu : menues) {
			acum+=(menu.getUnitCost()*menu.getQuantity());
		}
		return acum;
	}

}
