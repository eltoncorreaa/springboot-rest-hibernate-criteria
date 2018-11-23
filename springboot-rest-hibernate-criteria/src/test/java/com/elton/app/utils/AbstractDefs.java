package com.elton.app.utils;

import java.beans.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.elton.app.dto.AbstractDTO;

public abstract class AbstractDefs extends TaskExceptionIntTest{

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
}