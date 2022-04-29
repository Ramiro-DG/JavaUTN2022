package entities;

import java.sql.*;
import java.util.ArrayList;

public class ManejaBD {

	public ArrayList<Product> listAllProducts(){
		
		ArrayList<Product> prods = new ArrayList<>();
		
		try {
			Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","eladmin","nihongowakaranai");
			Statement stm=cnx.createStatement();
			ResultSet rs=stm.executeQuery("select * from product");
			
			while(rs.next()) {
				Product p=new Product();
				p.setDescription(rs.getString("description"));
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
				prods.add(p);
			}
			
			if(rs!=null){rs.close();}
            if(stm!=null){stm.close();}
			cnx.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	
	}
	
	public Product getOne(Product medprod) {
		Product p=null;
		try {
			Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","eladmin","nihongowakaranai");
			PreparedStatement stm=cnx.prepareStatement("select * from product where id =?");
			stm.setInt(1, (medprod.getId()));
			ResultSet rs=stm.executeQuery();
			
			
			if(rs.next()) {
				p=new Product();
				p.setDescription(rs.getString("description"));
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setShippingIncluded(rs.getBoolean("shippingIncluded"));	
			}
			
			if(rs!=null){rs.close();}
            if(stm!=null){stm.close();}
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public Product newProduct(Product pNew) {
		
		try {
			Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","eladmin","nihongowakaranai");
			PreparedStatement pstm=cnx.prepareStatement("insert into product(name, description, price, stock, shippingIncluded) values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				pstm.setString(1,pNew.getName());
				pstm.setString(2,pNew.getDescription());
				pstm.setDouble(3,pNew.getPrice());
				pstm.setInt(4,pNew.getStock());
				pstm.setBoolean(5,pNew.getShippingIncluded());
			
			pstm.executeUpdate(); //Retorna int con la cantidad de filas que se modificaron
			
			ResultSet rs=pstm.getGeneratedKeys();
			
			if(rs!=null && rs.next()) {
                pNew.setId(rs.getInt(1));
				}
			
	            if(rs!=null){rs.close();}
	            if(pstm!=null){pstm.close();}
				cnx.close();
			
			}catch (SQLException e) {
			e.printStackTrace();
		}
		return pNew;
		
	}
	
	public int deleteProduct(Product pDel) {
		int totalDeleted=0;
		try {
			Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","eladmin","nihongowakaranai");
			PreparedStatement pstm=cnx.prepareStatement("delete from product where id=?");
			pstm.setInt(1,pDel.getId());
			totalDeleted=pstm.executeUpdate();
			pstm.close();
			cnx.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDeleted;
	}
	
	public Product modifyProduct(Product pModify) {
			try {
				Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","eladmin", "nihongowakaranai");
				PreparedStatement pstm=
						cnx.prepareStatement("update product set name=?, description=?, price=?, stock=?, shippingIncluded=? where id=?");
		
				pstm.setString(1, pModify.getName());
				pstm.setString(2, pModify.getDescription());
				pstm.setDouble(3, pModify.getPrice());
				pstm.setInt(4, pModify.getStock());
				pstm.setBoolean(5, pModify.getShippingIncluded());
				pstm.setInt(6,pModify.getId());
						
				/*int cantModif=*/pstm.executeUpdate(); //Placeholder
				
	            if(pstm!=null){pstm.close();}
				cnx.close();					
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pModify;
		}		
	}

