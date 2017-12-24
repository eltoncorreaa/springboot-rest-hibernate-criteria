package com.elton.app.utils;

import java.beans.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elton.app.Application;
import com.elton.app.dto.AbstractDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringBootContextLoader.class, classes = Application.class)
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

	public Map<String, String> getMapaCampos() {
		throw new NotImplementedException("Não há mapa de campos implementado.");
	}

}
