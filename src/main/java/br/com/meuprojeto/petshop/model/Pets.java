package br.com.meuprojeto.petshop.model;

/**
 * 
 * @author 	Regiane Dias
 * Classe que contem todos os atributos que estão na base de dados
 *
 */

public class Pets {
	private int id_Pet;
	
	public int getId_Pet() {
		return id_Pet;
	}
	public void setId_Pet(int id_Pet) {
		this.id_Pet = id_Pet;
	}

	private String nome_Pet;
	private String especie_Pet;
	

	public String getNome_Pet() {
		return nome_Pet;
	}
	public void setNome_Pet(String nome_Pet) {
		this.nome_Pet = nome_Pet;
	}
	public String getEspecie_Pet() {
		return especie_Pet;
	}
	public void setEspecie_Pet(String especie_Pet) {
		this.especie_Pet = especie_Pet;
	}
	
	/**
	 * Método sobrescrito para exibir o nome do Pet, ao invés do hashcode, carregando o objeto 
	 */
	
	@Override
	public String toString() {
		return this.nome_Pet;
	}
	

}
