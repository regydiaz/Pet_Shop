package br.com.meuprojeto.petshop.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements IGenericDao {
	
	private Connection conec;
	
	public Connection getConnection(){
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PET_SHOP_BASE";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conec = DriverManager.getConnection(connectionUrl, "Regiane", "teste");
		
			System.out.println("Conexão Okay =)");
			conec.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
		} catch (Exception e) {
			System.out.println("Não foi possível se conectar");
		}
		return conec;
	}
	}
	



