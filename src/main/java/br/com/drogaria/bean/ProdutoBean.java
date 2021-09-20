package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "mbProduto")
@ViewScoped
public class ProdutoBean {
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Produto> listaProdutosFiltrados;

	private ArrayList<Fabricante> comboFabricantes;

	private Produto produto;

	// getters and setters
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public ArrayList<Produto> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}

	public void setListaProdutosFiltrados(ArrayList<Produto> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}

	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}

	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	// getters and setters//
	
	//methods

	public void carregarListagem() {

		try {
			ProdutoDAO pDao = new ProdutoDAO();
			listaProdutos = pDao.listarProdutos();

		} catch (DaoException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void prepararNovoProduto() {
		produto = new Produto();
		FabricanteDAO fDao = new FabricanteDAO();

		try {
			comboFabricantes = fDao.listarFabricantes();
		} catch (DaoException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void novoProduto() {
		ProdutoDAO pDao = new ProdutoDAO();
		
		try {
			pDao.cadastrarProduto(produto);
			
			listaProdutos = pDao.listarProdutos();
			
			JSFUtil.adicionarMensagemSucesso("Produto salvo com Sucesso");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluirProduto() {

		try {
			ProdutoDAO pDao = new ProdutoDAO();

			pDao.removerProduto(produto.getCodigo());

			listaProdutos = pDao.listarProdutos();

			JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso");

		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}
	
	public void prepararEditarProduto() {
		try {
			FabricanteDAO fDao = new FabricanteDAO();
			
			comboFabricantes = fDao.listarFabricantes();
		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void editarProduto() {

		try {
			ProdutoDAO pDao = new ProdutoDAO();

			pDao.atualizarProduto(produto);

			listaProdutos = pDao.listarProdutos();

			JSFUtil.adicionarMensagemSucesso("Produto atualizado com sucesso");

		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}
}
