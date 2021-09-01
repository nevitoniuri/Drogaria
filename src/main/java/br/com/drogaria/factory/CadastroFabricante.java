package br.com.drogaria.factory;


import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class CadastroFabricante {

	public static void main(String[] args) {
		
		Fabricante f1 = new Fabricante("Dell");
		Fabricante f2 = new Fabricante("Acer");

		FabricanteDAO fDao = new FabricanteDAO();
		fDao.cadastrar(f1);
		fDao.cadastrar(f2);
	}
}