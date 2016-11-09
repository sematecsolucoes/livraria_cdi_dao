package br.com.sematec.livraria.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sematec.livraria.modelo.Usuario;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario> {
	private static final long serialVersionUID = 1L;

	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(" select u from Usuario u " + " where u.email = :pEmail and u.senha = :pSenha", Usuario.class);
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		em.close();
		return true;
	}

	@PostConstruct
	public void init() {
		classe = Usuario.class;
	}
}
