package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;

public class FabricanteDAO {

	private EntityManager em;

	public FabricanteDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Fabricante fabricante) {
		try {
			em.getTransaction().begin();
			this.em.persist(fabricante);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

}