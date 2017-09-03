package br.com.meuprojeto.petshop.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements IGenericDao {

	private Connection conec;

	public Connection getConnection() {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=LOS_PETS";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conec = DriverManager.getConnection(connectionUrl,"sa","123mudar");

			System.out.println("Conexão Okay =)");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
		} catch (Exception e) {
			System.out.println("Não foi possível se conectar");
		}
		return conec;
	}

	private void finnaly() throws SQLException {
		conec.close();

	}

}
