package br.com.meuprojeto.petshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Inmetrics
 */
public class TesteConnection {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException {

		String connectionUrl = "jdbc:sqlserver://LP0766//MSSQLSERVER02:1480;" + "databaseName=PET_SHOP_BASE;"+"Integrated Security=True";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Connection conec = DriverManager.getConnection(connectionUrl);
			
			System.out.println("Conexão Okay =)");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
		} catch (Exception e) {
			System.out.println("Não foi possível se conectar");
		}
	}
	// fechar a conexao com o banco finnaly
}
