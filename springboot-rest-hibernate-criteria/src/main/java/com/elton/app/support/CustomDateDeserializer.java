package com.elton.app.support;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date>{

	@Override
	public Date deserialize(final JsonParser parser, final DeserializationContext ctx)
			throws IOException, JsonProcessingException {
		final JsonToken token = parser.getCurrentToken();
		Date retorno = null;
		if (token == JsonToken.VALUE_STRING){
			final String str = parser.getText().trim();
			try {
				retorno= new SimpleDateFormat("dd/MM/yyyy").parse(str);
			} catch (final ParseException e) {
				e.printStackTrace();
			}
		}

		if (token == JsonToken.VALUE_NUMBER_INT){
			retorno = new Date(parser.getLongValue());
		}

		return retorno;
	}
}
