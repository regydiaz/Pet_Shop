package br.com.meuprojeto.petshop.model;

public class DonoModel {
	private int id;
	private String nome_Dono;
	private String nome_Pet;
	private String celular;
	private String cep;
	

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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return this.nome_Dono;
	}

}
