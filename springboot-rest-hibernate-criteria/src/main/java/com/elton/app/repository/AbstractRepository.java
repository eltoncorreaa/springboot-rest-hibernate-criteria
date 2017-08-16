package com.elton.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractRepository {

	@PersistenceContext
	protected EntityManager em;

	protected Criteria createCriteria(final Class<?> persistenceClass) {
		return em.unwrap(Session.class).createCriteria(persistenceClass);
	}
}
