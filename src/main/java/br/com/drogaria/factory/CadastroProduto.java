package br.com.drogaria.factory;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;

public class CadastroProduto {

	public static void main(String[] args) {

		ProdutoDAO pDao = new ProdutoDAO();
		FabricanteDAO fDao = new FabricanteDAO();
		
		Produto p1 = new Produto("Notebook N4050 - i3 4th gen | 4gb RAM | 500gb HD", 15, 1599, fDao.buscarPorId(1));
		Produto p2 = new Produto("Notebook gamer i7 16gb", 10, 5999.90, fDao.buscarPorId(2));
		pDao.cadastrar(p1);
		pDao.cadastrar(p2);

	}
}
