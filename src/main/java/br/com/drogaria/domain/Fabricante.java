package br.com.drogaria.domain;

import javax.persistence.*;

@Entity
@Table(name = "fabricante")
public class Fabricante {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_fabricante")
	private int codigo;

	@Column(nullable = false)
	private String nome;
	
	
	//Construtores
	public Fabricante(String nome) {
		this.nome = nome;
	}
	
	public Fabricante() {
		
	}

	
	//getters & setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
