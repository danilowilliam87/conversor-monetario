package com.io.conversortest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.io.dominio.Dolar;
import com.io.dominio.Real;
import com.io.excecao.ValorInvalidoException;
import com.io.impl.ConversorDolar;

class ConversorDolarTest {

	
	
	@Test()
	void quandoOhValorEhInvalido() {
		BigDecimal valor = BigDecimal.ZERO;
		assertThrows(ValorInvalidoException.class, ()->{
			 new Dolar(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido2() {
		BigDecimal valor = new BigDecimal(0.0);
		assertThrows(ValorInvalidoException.class, ()->{
			 new Dolar(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido3() {
		BigDecimal valor = null;
		assertThrows(ValorInvalidoException.class, ()->{
			 new Dolar(valor);
		});
	}
	
	@Test
	void saidaFormatadaTest() {
		BigDecimal valor = new BigDecimal(100.0);
		Dolar dolar = new Dolar(valor);
		assertEquals("$100.00", dolar.toString());
	}
	
//	@Test
//	void converterDolarParaReal() {
//		BigDecimal valor = new BigDecimal(10.00);
//		BigDecimal cotacao = new BigDecimal(4.87);
//		Dolar dolar = new Dolar(valor);
//		Real real = new Real();
//		ConversorDolar conversorDolar = new ConversorDolar(cotacao);
//		real = (Real) conversorDolar.converter(dolar, real);
//	}

}
