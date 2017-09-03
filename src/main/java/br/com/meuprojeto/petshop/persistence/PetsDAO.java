package br.com.meuprojeto.petshop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.meuprojeto.petshop.model.Pets;
/**
 * 
 * @author Inmetrics
 * Classe que facilita a persistencia de dados na Base
 */


public class PetsDAO  implements IPetsDao{
	
	private Connection c;
	
	public PetsDAO() throws ClassNotFoundException, SQLException{
		IGenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	public void inserePet(Pets pet) throws SQLException {
		String sql = "INSERT INTO PET (ID_PET, NOME_PET, ESPECIE_PET) VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,pet.getId_Pet());
		ps.setString(2,pet.getNome_Pet());
		ps.setString(3, pet.getEspecie_Pet());
		ps.execute();
		ps.close();
		
	}

	public void atualizaPet(Pets pet) throws SQLException {
		String sql = "UPDATE PET SET  NOME_PET = ?, ESPECIE_PET = ? WHERE ID=?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,pet.getNome_Pet());
		ps.setString(2, pet.getEspecie_Pet());
		ps.setInt(3,pet.getId_Pet());
		ps.execute();
		ps.close();
		
		
	}

	public void excluiPet(Pets pet) throws SQLException {
		String sql = "delete Pet where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,pet.getId_Pet());
		ps.execute();
		ps.close();
	}

	/**
	 * O método abaixo retorna um ResultSet, que armazena a informação temporariamente
	 */
	public Pets consultaPet(Pets pet) throws SQLException {
		String sql = "Select ID_PET, NOME_PET, ESPECIE_PET from PET Where ID = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,pet.getId_Pet());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pet.setId_Pet(rs.getInt("ID_PET"));
			pet.setNome_Pet(rs.getString("NOME_PET"));
			pet.setEspecie_Pet(rs.getString("ESPECIE_PET"));
		}
		rs.close();
		ps.close();
		return pet;	
	}
	/**
	 * Consulta o conjunto todo dos PETS, através de um ArraList
	 */

	public List<Pets> consultaPet() throws SQLException {
		List<Pets> listaPets = new ArrayList<Pets>();
		String sql = "SELECT ID_PET, NOME_PET, ESPECIE_PET FROM PET";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Pets pet = new Pets();
			pet.setId_Pet(rs.getInt("ID_PET"));
			pet.setNome_Pet(rs.getString("NOME_PET"));
			pet.setEspecie_Pet(rs.getString("ESPECIE_PET"));
			listaPets.add(pet);
		}
		rs.close();
		ps.close();
		return listaPets;	

	}
	
	/**
	 * Método utiliza o último ID e acrescenta + 1
	 */

	public int proximoId() throws SQLException {
		String sql = "SELECT MAX(ID_PET) +1 AS proximo_id FROM PET";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("proximo_id");
		}else{
		return 1;
		}
	}
}
