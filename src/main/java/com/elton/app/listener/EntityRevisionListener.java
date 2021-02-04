package com.elton.app.listener;

import org.hibernate.envers.RevisionListener;

public class EntityRevisionListener implements RevisionListener {

	@Override
	public void newRevision(final Object o) {
		System.out.println("New revision is created: " + o);
	}
}
