package com.elton.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public Integer getVersion() {
		return version;
	}
	public void setVersion(final Integer version) {
		this.version = version;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(final Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(final Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getName())
				.append(getStartDate()).append(getStartDate()).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		final Task rhs = (Task) obj;
		return new EqualsBuilder().append(getName(), rhs.getName()).append(getStartDate(), rhs.getStartDate()).isEquals();
	}
}