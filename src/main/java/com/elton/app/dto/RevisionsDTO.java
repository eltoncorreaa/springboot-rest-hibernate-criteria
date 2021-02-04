package com.elton.app.dto;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RevisionsDTO extends ResourceSupport{

	private Long code;
	private Date date;
}
