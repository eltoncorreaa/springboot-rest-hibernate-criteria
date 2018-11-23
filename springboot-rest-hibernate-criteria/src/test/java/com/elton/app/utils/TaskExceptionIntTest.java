package com.elton.app.utils;

import java.util.ArrayList;
import java.util.List;

import com.elton.app.exception.MultipleTaskException;
import com.elton.app.exception.TaskException;

public abstract class TaskExceptionIntTest {

	protected List<String> validacao = new ArrayList<>();

	public void tratarErrosDeExcecao(final Exception e) {
		if (e instanceof MultipleTaskException) {
			final MultipleTaskException me = (MultipleTaskException) e;
			for (final TaskException exception : me.getExceptions()) {
				validacao.add(exception.getMessage());
			}
		} else if (e instanceof TaskException) {
			final TaskException exception = (TaskException) e;
			validacao.add(exception.getMessage());
		} else {
			validacao.add("erro generico");
		}
	}

	public Boolean verificaRetornoExcecao(final String mensagem, final String... params) {
		Boolean retorno = false;
		for (final String exceptionMessage : validacao) {
			if (exceptionMessage.equals(mensagem)) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}
}
