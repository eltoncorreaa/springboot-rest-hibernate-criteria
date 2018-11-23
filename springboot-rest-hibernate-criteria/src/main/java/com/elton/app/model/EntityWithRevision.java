package com.elton.app.model;

import lombok.Getter;

@Getter
public class EntityWithRevision <T> {

	private final RevisionsEntity revision;

	private final T entity;

	public EntityWithRevision(final RevisionsEntity revision, final T entity) {
		this.revision = revision;
		this.entity = entity;
	}
}
