package com.elton.app.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class MultipleTaskException extends RuntimeException{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7139972070262446093L;

	/**
	 * Lista de excecoes
	 */
	private final Set<TaskException> exceptions = new HashSet<TaskException>();

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultipleTaskException(final TaskException message) {
		exceptions.add(message);
	}

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultipleTaskException(final Collection<? extends TaskException> messageList) {
		exceptions.addAll(messageList);
	}

	public MultipleTaskException() {
		//Construtor padrao
	}


	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final TaskException message) {
		exceptions.add(message);
	}

	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends TaskException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<TaskException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final TaskException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
}
