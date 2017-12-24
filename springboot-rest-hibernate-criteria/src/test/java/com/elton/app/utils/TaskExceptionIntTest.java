package com.elton.app.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.elton.app.exception.MultipleTaskException;
import com.elton.app.exception.TaskException;

abstract class TaskExceptionIntTest {

	protected List<String> validacao = new ArrayList<>();

	public void tratarErrosDeExcecao(final Exception e){
		final List<String> excessoes= new ArrayList<>();
		if (e instanceof MultipleTaskException) {
			final MultipleTaskException me = (MultipleTaskException) e;
			for (final TaskException exception : me.getExceptions()) {
				excessoes.add(exception.getMessage());
			}
		}else if (e instanceof TaskException){
			final TaskException exception = (TaskException) e;
			excessoes.add(exception.getMessage());
		}else{
			excessoes.add("erro generico");
		}
		validacao.addAll(excessoes);
	}

	public Boolean verificaRetornoExcecao(final String mensagem, final String... params) {
		return verificaRetornoExcecao(validacao, mensagem, params);
	}

	public Boolean verificaRetornoExcecao(final List<String> excecoes, final String mensagem,
			final String... params) {
		Boolean retorno = false;

		for (final String exceptionMessage : excecoes) {
			if (exceptionMessage.equals(mensagem) && (ArrayUtils.isEmpty(params))) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}
}
