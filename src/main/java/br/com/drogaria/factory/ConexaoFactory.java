package br.com.drogaria.factory;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory {
	public static void main(String[] args) {
		// 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de
		// dados especificado no arquivo "persistence.xml"
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Drogaria");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// 2.1 - Criar instancias para serem adicionadas no banco de dados
		Fabricante f1 = new Fabricante("Acer");
		
		Produto p1 = new Produto("Notebook i3", 4, 2500.00, f1);

		// 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
		entityManager.getTransaction().begin();

		entityManager.persist(f1);
		entityManager.persist(p1);

		entityManager.getTransaction().commit();
		
		
		// 6 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();
	}
}
