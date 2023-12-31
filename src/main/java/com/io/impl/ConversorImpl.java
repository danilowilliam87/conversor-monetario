package com.io.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.io.dominio.Moeda;
import com.io.excecao.ConversorException;
import com.io.excecao.ReferenciaNulaException;
import com.io.interfaces.Conversor;
import com.io.util.DadosRetornoApi;
import com.io.util.JsonUtil;
import com.io.util.RestUtil;
import com.io.util.StringFormatUtils;
import com.io.util.Url;

public class ConversorImpl implements Conversor{

	@Override
	public Moeda converter(Moeda origem, Moeda destino) {
		// TODO Auto-generated method stub
		validarMoedas(origem, destino);
		
		try {
			String url = Url.getUrl(origem, destino);
			String json = RestUtil.get(url);
			json = StringFormatUtils.formatar(json);
			DadosRetornoApi api = JsonUtil.converterJsonParaObjeto(json);
			BigDecimal taxaDeCambio = new BigDecimal(api.getBid());
			double valorConvertido = origem.getValor()
					.multiply(taxaDeCambio)
					.doubleValue();
			BigDecimal valorFinal = acrescentarCasasDecimais(valorConvertido);
			
			destino.setValor(valorFinal);
			return destino;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ConversorException("Erro ao converter moeda : " + e.getMessage());
		}
	}
	
	private void validarMoedas(Moeda origem, Moeda destino) {
		if(origem == null || destino == null) {
			throw new ReferenciaNulaException("objetos nao podem ser nulos");
		}
		
		String nomeOrigem = origem.getClass().toString();
		String nomeDestino = destino.getClass().toString();
		
		if(nomeOrigem.equals(nomeDestino)) {
			throw new ConversorException("informe moedas de tipos diferentes");
		}
	}
	
	private BigDecimal acrescentarCasasDecimais(double valor) {
		BigDecimal novoValor = new BigDecimal(valor);
		if(valor > 0 && valor < 1) {
			String [] casasDecimais = Double.toString(valor).split("\\.");
			int numeroCasasDecimais = casasDecimais[1].length();
			novoValor.setScale(numeroCasasDecimais, RoundingMode.HALF_EVEN);
			return novoValor;
		}
		novoValor.setScale(2, RoundingMode.HALF_EVEN);
		return novoValor;
	}

}
