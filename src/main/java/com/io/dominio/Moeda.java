package com.io.dominio;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Moeda {
	
	protected BigDecimal valor;
	
	protected String sigla;
	
	protected String paramUrl;
	
	protected Locale locale;
	
	protected NumberFormat formatador;
	
	public Moeda() {
		super();
	}

	public Moeda(BigDecimal valor) {
		this.valor = valor;
	}



	public BigDecimal getValor() {
		return valor;
	}



	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getParamUrl() {
		return paramUrl;
	}

	public void setParamUrl(String paramUrl) {
		this.paramUrl = paramUrl;
	}
	
	
	


}
