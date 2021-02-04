package com.elton.app.exception;

public class TaskException extends Exception{

	private static final long serialVersionUID = 1L;

	public TaskException() {
		//Construtor padrao
	}

	public TaskException(final String message) {
		super(message);
	}

	public TaskException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public TaskException(final Throwable cause) {
		super(cause);
	}
}
