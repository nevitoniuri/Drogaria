package br.com.drogaria.factory;

import br.com.drogaria.dao.FabricanteDAO;

public class RemoveFabricante {

	public static void main(String[] args) {
		FabricanteDAO fDao = new FabricanteDAO();
		
		fDao.removerFabricante(3);
	}
}
