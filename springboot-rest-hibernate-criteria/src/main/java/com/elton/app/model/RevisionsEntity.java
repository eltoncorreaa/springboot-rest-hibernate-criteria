package com.elton.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import com.elton.app.listener.EntityRevisionListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "REVISIONS_ENTITY")
@SequenceGenerator(name = "SEQUENCE_REVISIONS_ENTITY", sequenceName = "SEQUENCE_REVISIONS_ENTITY")
@RevisionEntity(value = EntityRevisionListener.class)
@Getter @Setter @EqualsAndHashCode
public class RevisionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_REVISIONS_ENTITY")
	@Column(name = "CODE", precision = 12, scale = 0)
	@RevisionNumber
	private Long code;

	@Column(name = "DATE", nullable = false)
	@RevisionTimestamp
	private Date date;

	public static RevisionsEntity toDomain(final Long revisionId, final Date revisionDate) {
		final RevisionsEntity revisionsEntity = new RevisionsEntity();
		revisionsEntity.setCode(revisionId);
		revisionsEntity.setDate(revisionDate);
		return revisionsEntity;
	}
}