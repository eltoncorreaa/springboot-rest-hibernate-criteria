package com.elton.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TASK")
@SequenceGenerator(name = "SEQUENCE_TASK", sequenceName = "SEQUENCE_TASK")
@Audited
@Getter @Setter @EqualsAndHashCode
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_TASK")
	@Column(name = "ID", precision = 12, scale = 0)
	private Long id;

	@Column(name = "TASK_NAME", nullable = false, length = 200)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_START_DATE", nullable = false, length = 7)
	private Date startDate;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_TIME", length = 7)
	private Date creationTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_TIME", length = 7)
	private Date lastUpdateTime;
}