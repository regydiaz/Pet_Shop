package br.com.meuprojeto.petshop.persistence;

import java.sql.Connection;
/**
 * 
 * @author Regiane Dias
 * Interface responsável por fazer a conexão com a base de dados, passando a conexão para outras classes DAO 
 *
 */

public interface IGenericDao {
	public Connection getConnection() throws ClassNotFoundException;

}
