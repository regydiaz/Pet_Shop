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
		ps.setString(3, pet.getNome_Dono());
		ps.execute();
		ps.close();
		// inserir os metodos de especie e fone do dono
		
	}

	public void atualizaEspecie(EspecieModel pet) throws SQLException {
		String sql = "UPDATE PETS SET  NOME_PET = ?, ESPECIE_PET = ?, NOME_DONO = ?,FONE_DONO = ? WHERE ID=?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,pet.getNome_Pet());
		ps.setString(2, pet.getNome_Dono());
		ps.setInt(3,pet.getId());
		ps.execute();
		ps.close();
		// inserir os metodos de especie e fone do dono
		
		
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
			pet.setNome_Pet(rs.getString("NOME_PET")); // tá faltando os outros elementos
		}return pet;	
	}

	public List<EspecieModel> consultaPet() throws SQLException {
		List<EspecieModel> especiemodel = new ArrayList<EspecieModel>();
		String sql = "Select ID_PET, NOME_PET, ESPECIE_PET, NOME_DONO,FONE_DONO from PETS";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			EspecieModel especie = new EspecieModel();
			//especie.setId(id);

			
		}

		
		// TODO Auto-generated method stub
		return null;
	}



	

}
