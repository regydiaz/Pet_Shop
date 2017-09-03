package br.com.meuprojeto.petshop.persistence;

import java.sql.SQLException;
import java.util.List;
import br.com.meuprojeto.petshop.model.Pets;


public interface IPetsDao {
	public void inserePet(Pets pet) throws SQLException;
	public void atualizaPet(Pets pet) throws SQLException;
	public void excluiPet(Pets pet) throws SQLException;
	public Pets consultaPet(Pets pet) throws SQLException;
	public List<Pets> consultaPet()throws SQLException; 
	public int proximoId() throws SQLException;

}
