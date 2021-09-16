package br.com.drogaria.factory;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;

public class CadastroProduto {

	public static void main(String[] args) throws DaoException {

		ProdutoDAO pDao = new ProdutoDAO();
		FabricanteDAO fDao = new FabricanteDAO();
//		
		Produto p1 = new Produto("Notebook N4050 - i3 4th gen | 4gb RAM | 500gb HD", 15, 1599.00, fDao.buscarFabricante(1));
//		Produto p2 = new Produto("Notebook gamer i7 16gb", 10, 5999.90, fDao.buscarFabricante(2));
//		Produto p3 = new Produto("Notebook positivo", 95, 1299.90, fDao.buscarFabricante(3));
		pDao.cadastrarProduto(p1);
//		pDao.cadastrarProduto(p2);
//		pDao.cadastrarProduto(p3);
	}
}
