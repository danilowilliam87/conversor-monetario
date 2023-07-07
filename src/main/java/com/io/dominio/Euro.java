package com.io.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import com.io.excecao.ValorInvalidoException;

public class Euro extends Moeda {

	public Euro(BigDecimal valor) {
		if (valor == null ||  valor.doubleValue() <= 0) {
           throw new ValorInvalidoException("Valor invalido passado com parametro");
		}
		this.valor = valor.setScale(2,RoundingMode.HALF_EVEN);
		this.locale = new Locale("de", "DE");
		this.formatador = NumberFormat.getCurrencyInstance(locale);
		this.formatador.setMaximumFractionDigits(2);
		this.formatador.setMinimumFractionDigits(2);
		this.sigla = "EUR (€)";
		this.paramUrl = "EUR";
	}
	
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
	
	public String getSigla() {
		return this.sigla;
	}
	
	public String getUrlParam() {
		return this.paramUrl;
	}
	
	@Override
	public String toString() {
		return this.formatador.format(this.valor);
	}
	
	
}
