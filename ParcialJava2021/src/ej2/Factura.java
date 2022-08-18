package ej2;

import java.util.LinkedList;

public class Factura {
	private static final Double iva=0.21;
	
	public Double getTotal(LinkedList<BillItem> items, boolean includeTax) {
		Double total=0.0;
		for (BillItem billItem : items) {
			total+=(billItem.getUnitPrice()*billItem.getQuantity());
		}
		if (includeTax) {
			total+=total*iva;
		}
		return total;
	}

}
