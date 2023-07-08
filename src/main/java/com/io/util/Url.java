package com.io.util;

import com.io.dominio.Moeda;

public class Url {
	
	private static final String URL_BASE = "https://economia.awesomeapi.com.br/last/";
	
	public static String getUrl(Moeda origem, Moeda destino) {
		return URL_BASE.concat(origem.getParamUrl())
				.concat("-")
				.concat(destino.getParamUrl());
	}

}
