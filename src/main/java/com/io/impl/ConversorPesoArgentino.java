package com.io.impl;

import java.math.BigDecimal;

import com.io.dominio.Moeda;
import com.io.dominio.PesoArgentino;
import com.io.excecao.ReferenciaNulaException;
import com.io.interfaces.Conversor;

public class ConversorPesoArgentino implements Conversor {
	
	private BigDecimal valorCotacao;

	@Override
	public Moeda converter(Moeda origem, Moeda destino) {
		if(origem == null || destino == null) {
			throw new ReferenciaNulaException("objetos nulos");
		}
		destino.setValor((origem.getValor().divide(valorCotacao)));
		return destino;
	}

	@Override
	public PesoArgentino converter(Moeda origem) {
		if(origem == null) {
			throw new ReferenciaNulaException("objetos nulos");
		}
		return new PesoArgentino(origem.getValor().multiply(valorCotacao));
	}
}
