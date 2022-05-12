package logic;

import java.util.Scanner;
import entities.Product;

public class Creator {
	
	public Product createProduct(Scanner lectore) {
		Product p=new Product();
		System.out.print("Ingrese el nombre del producto: ");
		p.setName(lectore.nextLine());
		System.out.print("Ingrese la descripcion del producto: ");
		p.setDescription(lectore.nextLine());
		System.out.print("Ingrese el precio del producto: ");
		p.setPrice(Double.parseDouble(lectore.nextLine()));
		System.out.print("Ingrese el stock inicial del producto: ");
		p.setStock(Integer.parseInt(lectore.nextLine()));
		System.out.print("¿El producto tiene envio gratis? (1/si, 0/no): ");
		p.setShippingIncluded((Integer.parseInt(lectore.nextLine()) == 0) ? false : true);
		
		return p;
	}
	
	public Product createIdSearchProduct(Scanner lectora) {
		Product p=new Product();
		System.out.print("Ingrese el id del producto: ");
		p.setId(Integer.parseInt(lectora.nextLine()));
		
		return p;
	}
}
