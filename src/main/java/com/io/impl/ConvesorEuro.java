package com.io.impl;

import java.math.BigDecimal;

import com.io.dominio.Euro;
import com.io.dominio.Moeda;
import com.io.excecao.ReferenciaNulaException;
import com.io.excecao.ValorInvalidoException;
import com.io.interfaces.Conversor;

public class ConvesorEuro implements Conversor {

	private BigDecimal valorCotacao;
	
	public ConvesorEuro(BigDecimal valorCotacao) {
		if (valorCotacao == null ||  valorCotacao.doubleValue() <= 0) {
	           throw new ValorInvalidoException("Valor invalido passado com parametro");
			}
		this.valorCotacao = valorCotacao;
	}

	@Override
	public Moeda converter(Moeda origem, Moeda destino) {
		if(origem == null || destino == null) {
			throw new ReferenciaNulaException("objetos nulos");
		}
		destino.setValor((origem.getValor().divide(valorCotacao)));
		return destino;
	}
	
	@Override
	public Euro converter(Moeda origem) {
		if(origem == null) {
			throw new ReferenciaNulaException("objetos nulos");
		}
		return new Euro(origem.getValor().multiply(valorCotacao));
	}

}
