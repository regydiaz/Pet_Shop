package br.com.meuprojeto.petshop.model;

public class DonoModel {
	private int id;
	private String nome_Dono;
	private String nome_Pet;
	private String especie_Pet;

	public String getEspecie_Pet() {
		return especie_Pet;
	}
	public void setEspecie_Pet(String especie_Pet) {
		this.especie_Pet = especie_Pet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_Dono() {
		return nome_Dono;
	}
	public void setNome_Dono(String nome_Dono) {
		this.nome_Dono = nome_Dono;
	}
	public String getNome_Pet() {
		return nome_Pet;
	}
	public void setNome_Pet(String nome_Pet) {
		this.nome_Pet = nome_Pet;
	}

	@Override
	public String toString() {
		return this.nome_Pet;
	}

}
