package br.com.meuprojeto.petshop.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.meuprojeto.petshop.model.EspecieModel;

public class EspecieDAO  implements IEspecieDao{
	
	private Connection c;
	
	public EspecieDAO() throws ClassNotFoundException, SQLException{
		IGenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	public void insereEspecie(EspecieModel pet) throws SQLException {
		String sql = "INSERT INTO PETS (ID_PET, NOME_PET, ESPECIE_PET, NOME_DONO,FONE_DONO) VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,pet.getId());
		ps.setString(2,pet.getNome_Pet());
		ps.setString(3, pet.getEspecie_Pet());
		ps.setString(4, pet.getNome_Dono());
		ps.setString(5, pet.getFone_Dono());
		ps.execute();
		ps.close();
		
	}

	public void atualizaEspecie(EspecieModel pet) throws SQLException {
		String sql = "UPDATE PETS SET  NOME_PET = ?, ESPECIE_PET = ?, NOME_DONO = ?,FONE_DONO = ? WHERE ID=?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,pet.getNome_Pet());
		ps.setString(2, pet.getNome_Dono());
		ps.setString(3, pet.getEspecie_Pet());
		ps.setString(4, pet.getFone_Dono());
		ps.setInt(5,pet.getId());
		ps.execute();
		ps.close();
		
		
	}

	public void excluiEspecie(EspecieModel pet) throws SQLException {
		String sql = "delete Pets where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,pet.getId());
		ps.execute();
		ps.close();

	
	}

	public EspecieModel consultaEspecie(EspecieModel pet) throws SQLException {
		String sql = "Select ID_PET, NOME_PET, ESPECIE_PET, NOME_DONO,FONE_DONO from PETS Where ID = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,pet.getId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pet.setId(rs.getInt("ID_PET"));
			pet.setNome_Dono(rs.getString("NOME_DONO"));
			pet.setNome_Pet(rs.getString("NOME_PET"));
			pet.setEspecie_Pet(rs.getString("ESPECIE_PET"));
			pet.setFone_Dono(rs.getString("FONE_DONO"));
		}
		rs.close();
		ps.close();
		return pet;	
	}

	public List<EspecieModel> consultaPet() throws SQLException {
		List<EspecieModel> listaEspecie = new ArrayList<EspecieModel>();
		String sql = "Select ID_PET, NOME_PET, ESPECIE_PET, NOME_DONO,FONE_DONO from PETS Where ID = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			EspecieModel pet = new EspecieModel();
			pet.setId(rs.getInt("ID_PET"));
			pet.setNome_Dono(rs.getString("NOME_DONO"));
			pet.setNome_Pet(rs.getString("NOME_PET"));
			pet.setEspecie_Pet(rs.getString("ESPECIE_PET"));
			pet.setFone_Dono(rs.getString("FONE_DONO"));
			listaEspecie.add(pet);
		}
		rs.close();
		ps.close();
		return listaEspecie;	

	}

	public int proximoId() throws SQLException {
		String sql = "SELECT MAX(ID) +1 as proximo_idfrom PETS";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("proximo_id");
		}else{
		return 1;
		}
	}



	

}
