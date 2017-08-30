package br.com.meuprojeto.petshop.controller;

import java.sql.SQLException;
import java.util.List;
import br.com.meuprojeto.petshop.model.EspecieModel;


public interface IEspecieDao {
	public void insereEspecie(EspecieModel pet) throws SQLException;
	public void atualizaEspecie(EspecieModel pet) throws SQLException;
	public void excluiEspecie(EspecieModel pet) throws SQLException;
	public EspecieModel consultaEspecie(EspecieModel pet) throws SQLException;
	public List<EspecieModel> consultaPet()throws SQLException; 

}
