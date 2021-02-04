package com.elton.app.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.elton.app.model.Task;

public class TaskRepositoryImpl extends AbstractRepository implements TaskRepositoryCustom{

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findByFilter(final Task task) {
		final Criteria criteria = createCriteria(Task.class);

		if(!task.getName().isEmpty()) {
			criteria.add(Restrictions.ilike("name", task.getName(), MatchMode.ANYWHERE));
		}
		return criteria.list();
	}
}