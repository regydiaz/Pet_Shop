package br.com.meuprojeto.petshop.model;

public class EspecieModel {
	private int id;
	private String nome_Pet;
	private String nome_Dono;
	private String sexo_Pet;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_Pet() {
		return nome_Pet;
	}
	public void setNome_Pet(String nome_Pet) {
		this.nome_Pet = nome_Pet;
	}
	public String getNome_Dono() {
		return nome_Dono;
	}
	public void setNome_Dono(String nome_Dono) {
		this.nome_Dono = nome_Dono;
	}
	public String getSexo_Per() {
		return sexo_Pet;
	}
	public void setSexo_Per(String sexo_Per) {
		this.sexo_Pet = sexo_Per;
	}
	@Override
	public String toString() {
		return this.nome_Pet;
	}
	
	
	

}
