package com.elton.app.dto;

public abstract class AbstractDTO {

	private Long id;
	private Integer version;

	public Long getId() {
		return id;
	}
	public void setId(final Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(final Integer version) {
		this.version = version;
	}
}