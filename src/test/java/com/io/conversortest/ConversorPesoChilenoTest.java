package com.io.conversortest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.io.dominio.Dolar;
import com.io.dominio.Moeda;
import com.io.dominio.PesoArgentino;
import com.io.dominio.PesoChileno;
import com.io.dominio.Real;
import com.io.excecao.ValorInvalidoException;
import com.io.impl.ConversorImpl;

class ConversorPesoChilenoTest {

	
	
	@Test()
	void quandoOhValorEhInvalido() {
		BigDecimal valor = BigDecimal.ZERO;
		assertThrows(ValorInvalidoException.class, ()->{
			 new PesoChileno(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido2() {
		BigDecimal valor = new BigDecimal(0.0);
		assertThrows(ValorInvalidoException.class, ()->{
			 new PesoChileno(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido3() {
		BigDecimal valor = null;
		assertThrows(ValorInvalidoException.class, ()->{
			 new PesoChileno(valor);
		});
	}
	
	@Test
	void saidaFormatadaTest() {
		BigDecimal valor = new BigDecimal(100.0);
		PesoChileno pc = new PesoChileno(valor);
		assertEquals("$100,00", pc.toString());
	}
	
	@Test
	void converterParaReal() {
		BigDecimal valor = new BigDecimal(10.00);
		Moeda origem = new PesoChileno(valor);
		Moeda destino = new Real();
		ConversorImpl impl = new ConversorImpl();
		double valorFinal = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(0.0603, valorFinal, 0.001);
	}
	
	
	
	@Test
	void converterParaDolar() {
		BigDecimal valor = new BigDecimal(10.00);
		Moeda origem = new PesoChileno(valor);
		Moeda destino = new Dolar();
		ConversorImpl impl = new ConversorImpl();
		double retorno = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(0.0124, retorno, 0.001);
	}

}
