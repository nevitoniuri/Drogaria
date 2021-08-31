package br.com.drogaria.domain;

import javax.persistence.*;

@Entity
public class Produto {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private int quantidade;

	@Column(nullable = false)
	private double preco;

	@ManyToOne
	private Fabricante fabricante;

	// construtores-------------------
	public Produto(String descricao, int quantidade, double preco, Fabricante fabricante) {

		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fabricante = fabricante;
	}
	
	public Produto() {
		
	}

	// getters and setters--------------
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
