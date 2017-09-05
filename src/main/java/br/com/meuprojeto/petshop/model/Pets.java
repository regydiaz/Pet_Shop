package br.com.meuprojeto.petshop.model;

/**
 * 
 * @author 
 * Regiane Dias Classe que contem todos os atributos que estão na base
 * de dados
 *
 */

public class Pets {
	private int idPet;
	private String nomePet;
	private String especiePet;

	public int getId_Pet() {
		return idPet;
	}

	public void setId_Pet(int id_Pet) {
		this.idPet = id_Pet;
	}

	public String getNome_Pet() {
		return nomePet;
	}

	public void setNome_Pet(String nome_Pet) {
		this.nomePet = nome_Pet;

	}

	public String getEspecie_Pet() {
		return especiePet;
	}

	public void setEspecie_Pet(String especie_Pet) {
		this.especiePet = especie_Pet;
	}

	/**
	 * Método sobrescrito para exibir o nome do Pet, ao invés do hashcode,
	 * carregando o objeto
	 */

	@Override
	public String toString() {
		return this.nomePet;
	}

}
