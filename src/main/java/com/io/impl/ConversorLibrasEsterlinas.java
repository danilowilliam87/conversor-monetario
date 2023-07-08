package com.io.impl;

import java.math.BigDecimal;

import com.io.dominio.LibraEsterlina;
import com.io.dominio.Moeda;
import com.io.excecao.ReferenciaNulaException;
import com.io.interfaces.Conversor;

public class ConversorLibrasEsterlinas implements Conversor {
	
	private BigDecimal valorCotacao;

	public ConversorLibrasEsterlinas(BigDecimal valorCotacao) {
		super();
		this.valorCotacao = valorCotacao;
	}

	@Override
	public Moeda converter(Moeda origem, Moeda destino) {
		// TODO Auto-generated method stub
		if(origem == null || destino == null) {
			throw new ReferenciaNulaException("objetos nulos");
		}
		destino.setValor((origem.getValor().divide(valorCotacao)));
		return destino;
	}
	
	
	@Override
	public LibraEsterlina converter(Moeda origem) {
		// TODO Auto-generated method stub
		if(origem == null) {
			throw new ReferenciaNulaException("objetos nulos");
		}
		return new LibraEsterlina(origem.getValor().multiply(valorCotacao));
	}

	public BigDecimal getValorCotacao() {
		return valorCotacao;
	}

	public void setValorCotacao(BigDecimal valorCotacao) {
		this.valorCotacao = valorCotacao;
	}
	
	

}
