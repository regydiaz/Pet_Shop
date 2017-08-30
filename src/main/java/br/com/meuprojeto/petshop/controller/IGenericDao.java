package br.com.meuprojeto.petshop.controller;

import java.sql.Connection;

public interface IGenericDao {
	public Connection getConnection() throws ClassNotFoundException;

}
