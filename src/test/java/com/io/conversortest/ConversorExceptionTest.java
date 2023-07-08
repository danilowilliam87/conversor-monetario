package com.io.conversortest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.io.dominio.Dolar;
import com.io.dominio.Real;
import com.io.excecao.ConversorException;
import com.io.excecao.ReferenciaNulaException;
import com.io.impl.ConversorImpl;

class ConversorExceptionTest {

	@Test
	void quandoEhInformadoMesmaMoeda() {
		Real real = new Real();
		ConversorImpl conversorImpl = new ConversorImpl();
		assertThrows(ConversorException.class, ()->{
			conversorImpl.converter(real, real);
		});
	}
	
	@Test
	void quandoEhInformadoObjetosNulos() {
		Real real = null;
		Dolar dolar = new Dolar();
		ConversorImpl conversorImpl = new ConversorImpl();
		assertThrows(ReferenciaNulaException.class, ()->{
			conversorImpl.converter(real, dolar);
		});
	}
	
	@Test
	void quandoEhInformadoObjetosNulos2() {
		Real real = null;
		Dolar dolar = new Dolar();
		ConversorImpl conversorImpl = new ConversorImpl();
		assertThrows(ReferenciaNulaException.class, ()->{
			conversorImpl.converter(dolar, real);
		});
	}

}
