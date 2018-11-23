package com.elton.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOWithRevision <T>{

	private RevisionsDTO revision;
	private T dto;
}
