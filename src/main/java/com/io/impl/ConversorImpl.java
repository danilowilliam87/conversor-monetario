package com.io.impl;

import java.math.BigDecimal;

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
		if(origem == null || destino == null) {
			throw new ReferenciaNulaException("objetos nao podem ser nulos");
		}
		
		if(origem == destino) {
			throw new ConversorException("informe moedas de tipos diferentes");
		}
		
		String url = Url.getUrl(origem, destino);
		String json = RestUtil.get(url);
		json = StringFormatUtils.formatar(json);
		DadosRetornoApi api = JsonUtil.converterJsonParaObjeto(json);
		BigDecimal taxaDeCambio = new BigDecimal(api.getBid());
		double valorConvertido = origem.getValor().multiply(taxaDeCambio).doubleValue();
		destino.setValor(new BigDecimal(valorConvertido));
		return destino;
	}

}
