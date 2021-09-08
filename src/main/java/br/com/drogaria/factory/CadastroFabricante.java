package br.com.drogaria.factory;


import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class CadastroFabricante {

	public static void main(String[] args) {
		
		Fabricante f1 = new Fabricante("Dell");
		Fabricante f2 = new Fabricante("Acer");
		Fabricante f3 = new Fabricante("Positivo");
		Fabricante f4 = new Fabricante("Logitech");

		FabricanteDAO fDao = new FabricanteDAO();
		fDao.cadastrarFabricante(f1);
		fDao.cadastrarFabricante(f2);
		fDao.cadastrarFabricante(f3);
		fDao.cadastrarFabricante(f4);
		
		
		
	}
}