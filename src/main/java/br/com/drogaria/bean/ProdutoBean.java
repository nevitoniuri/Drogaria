package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "mbProduto")
@ViewScoped
public class ProdutoBean {
	private ArrayList<Produto> listaProdutos;

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public void carregarListagem() {

		try {
			ProdutoDAO pDao = new ProdutoDAO();
			listaProdutos = pDao.listarProdutos();

		} catch (DaoException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
}
