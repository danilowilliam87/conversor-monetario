package com.io.interfaces;

import com.io.dominio.Moeda;
/**
 * @author Danilo William
 */
public interface Conversor {

	/**
	 * 
	 * @param origem
	 * @return Moeda
	 * converte a moeda origem para a moeda de destino
	 */
	public Moeda converter(Moeda origem, Moeda destino);

}
