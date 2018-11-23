package com.elton.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class AbstractDTO {

	private Long id;
	private Integer version;
}