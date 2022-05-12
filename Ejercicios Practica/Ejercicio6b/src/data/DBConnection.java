package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection instancia;
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="eladmin";
	private String pass="nihongowakaranai";
	private String schema="javamarket";
	private int activeUsers=0;
	private Connection cnx=null;
	
	
	private DBConnection() {
		try { 
				Class.forName(driver);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();}
	}
	
	public static DBConnection getInstancia() {
		if(instancia==null) {
			instancia=new DBConnection();		
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(cnx==null || cnx.isClosed()) {		
				cnx=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+schema,user,pass);
				activeUsers=0;
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		activeUsers++;
		return cnx;
	}

	public void closeConn() {
		activeUsers--;
		try {
			if (activeUsers<=0) {
				cnx.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
