package com.elton.app.util;

import java.beans.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.elton.app.Application;
import com.elton.app.dto.AbstractDTO;
import com.elton.app.exception.MultipleTaskException;
import com.elton.app.exception.TaskException;

@ContextConfiguration(loader = SpringBootContextLoader.class, classes = Application.class)
@SpringBootTest
public class SpringIntegrationTest {

	protected List<String> validacao = new ArrayList<>();

	protected void preencheCampo(final AbstractDTO model, final String campo, final Object valor) throws Exception {
		final Statement st = new Statement(model, getMapaCampos().get(campo), new Object[] { valor });
		st.execute();
	}

	protected Date getStringComoData(final String strData) {
		Date data = null;
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = sdf.parse(strData);
		} catch (final ParseException e) {
			// data inválida. Retornar null
		}
		return data;
	}

	protected Integer getStringComoInteger(final String strInteger) {
		Integer inteiro = null;
		try {
			inteiro = Integer.valueOf(strInteger);
		} catch (final NumberFormatException e) {
			// inteiro inválido. Retornar null
		}
		return inteiro;
	}

	public Map<String, String> getMapaCampos() throws Exception {
		throw new Exception("Não há mapa de campos implementado.");
	}

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