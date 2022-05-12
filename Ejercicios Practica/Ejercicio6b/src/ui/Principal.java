package ui;

import java.util.Scanner;
import data.ManejaBD;
import entities.Product;
import logic.Creator;


public class Principal {

	public static void main(String[] args) {
		int opc=2;
		Creator c=new Creator();
		ManejaBD bd=new ManejaBD();
		Scanner lector=new Scanner(System.in);
		
		while(opc!=0) {
			System.out.println("1-Listar todos los productos cargados");
			System.out.println("2-Buscar producto especifico por ID");
			System.out.println("3-Cargar nuevo producto");
			System.out.println("4-Modificar producto");			
			System.out.println("5-Eliminar producto");
			System.out.print("Ingrese la opcion:");


			opc=Integer.parseInt(lector.nextLine());
			System.out.println(opc);
				switch (opc) {
				case 1:
					for (Product prod : bd.listAllProducts()) {
						System.out.println(prod);
					}
					
					break;
					
				case 2:
					Product search=bd.getOne(c.createIdSearchProduct(lector));
					if(search!=null) {
						System.out.println(search);
						}
					else {
						System.out.println("Producto no encontrado");
						}
					break;
					
				case 3:
					System.out.println(bd.newProduct(c.createProduct(lector)));
					break;
					
				case 4:
					Product result=bd.getOne(c.createIdSearchProduct(lector));
					if(result!=null) {
						bd.modifyProduct(modifyProductData(result,lector)); 
					}
					break;
				case 5:
					Product suspect=bd.getOne(c.createIdSearchProduct(lector));
					if(suspect!=null) {
						System.out.println(suspect);
						System.out.println("¿Esta seguro que desea borrar el producto? S/N");
						if((lector.nextLine().equalsIgnoreCase("S"))) {
							bd.deleteProduct(suspect);
						}					
					}
					break;
					default:break;
				}	
				
		}
		lector.close();
	}	
	

	private static Product modifyProductData(Product p, Scanner lector2) {
		int opc=1;
		while(opc!=0) {
			System.out.println(p);
			System.out.println("1-Nombre"); 
			System.out.println("2-Descripcion");
			System.out.println("3-Precio");
			System.out.println("4-Stock");			
			System.out.println("5-Envio Gratis");
			System.out.print("Ingrese el campo a modificar:");
			opc=Integer.parseInt(lector2.nextLine());
			
			switch (opc) {
			case 1:
				System.out.print("Ingrese el nombre del producto: ");
				p.setName(lector2.nextLine());
				break;
			case 2:
				System.out.print("Ingrese la descripcion del producto: ");
				p.setDescription(lector2.nextLine());
				break;
			case 3:
				System.out.print("Ingrese el precio del producto: ");
				p.setPrice(Double.parseDouble(lector2.nextLine()));
				break;
			case 4:
				System.out.print("Ingrese el stock inicial del producto: ");
				p.setStock(Integer.parseInt(lector2.nextLine()));
				break;
			case 5:
				System.out.print("¿El producto tiene envio gratis? (1/si, 0/no): ");
				p.setShippingIncluded((Integer.parseInt(lector2.nextLine()) == 0) ? false : true);
				break;
			}
		}return p;
	}
		
	
	

}
