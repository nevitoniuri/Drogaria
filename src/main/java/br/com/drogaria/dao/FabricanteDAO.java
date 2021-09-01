package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JPAUtil;

public class FabricanteDAO {

	private EntityManager em;

//	public FabricanteDAO(EntityManager em) {
//		this.em = em;
//	}

	public void cadastrar(Fabricante fabricante) {
		try {
			em = JPAUtil.getEntityManager(); ///sempre colocar nos m�todos...
			em.getTransaction().begin();
			this.em.persist(fabricante);
			em.getTransaction().commit();
			System.out.println("Fabricante cadastrado.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("N�o foi poss�vel cadastrar o fabricante.");
		} finally {
			em.close();
		}
	}

	public Fabricante buscarPorId(int id) {
		em = JPAUtil.getEntityManager(); ///sempre colocar nos m�todos...
		return em.find(Fabricante.class, id);
	}

}