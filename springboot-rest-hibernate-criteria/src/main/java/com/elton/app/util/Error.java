package com.elton.app.util;

import java.io.Serializable;
import java.util.List;

public class Error implements Serializable {

	private static final long serialVersionUID = 8467553072140041374L;

	private int cod;
	private List<String> error;

	public int getCod() {
		return cod;
	}
	public void setCod(final int cod) {
		this.cod = cod;
	}
	public Error(final int cod, final List<String> error) {
		super();
		this.cod = cod;
		this.error = error;
	}
	public List<String> getError() {
		return error;
	}
	public void setError(final List<String> error) {
		this.error = error;
	}
}
