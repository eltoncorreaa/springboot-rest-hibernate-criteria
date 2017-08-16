package com.elton.app.dto;

import java.util.Date;

import com.elton.app.support.CustomDateDeserializer;
import com.elton.app.support.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TaskDTO extends AbstractDTO {

	private String name;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date startDate;

	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}
}