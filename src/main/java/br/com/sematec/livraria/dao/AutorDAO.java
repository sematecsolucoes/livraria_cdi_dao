package br.com.sematec.livraria.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import br.com.sematec.livraria.modelo.Autor;

@RequestScoped
public class AutorDAO extends DAO<Autor> {
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		classe = Autor.class;
	}

}
