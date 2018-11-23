package com.elton.app.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Repository;

import com.elton.app.model.EntityWithRevision;
import com.elton.app.model.RevisionsEntity;
import com.elton.app.model.Task;

@Repository
@Transactional
public class TaskRevisionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EntityWithRevision<Task>> listTaskRevisions(final Long taskCode) {
		final AuditReader auditReader = AuditReaderFactory.get(entityManager);

		final List<Number> revisions = auditReader.getRevisions(Task.class, taskCode);

		final List<EntityWithRevision<Task>> taskRevisions = new ArrayList<>();
		for (final Number revision : revisions) {
			final Task taskRevision = auditReader.find(Task.class, taskCode, revision);
			final Date revisionDate = auditReader.getRevisionDate(revision);
			taskRevisions.add(new EntityWithRevision(RevisionsEntity.toDomain(revision.longValue(), revisionDate), taskRevision));
		}
		return taskRevisions;
	}
}