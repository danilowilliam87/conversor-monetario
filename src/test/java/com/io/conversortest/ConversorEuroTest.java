package com.io.conversortest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.io.dominio.Dolar;
import com.io.dominio.Euro;
import com.io.dominio.LibraEsterlina;
import com.io.dominio.Moeda;
import com.io.dominio.PesoArgentino;
import com.io.dominio.PesoChileno;
import com.io.dominio.Real;
import com.io.excecao.ValorInvalidoException;
import com.io.impl.ConversorImpl;

class ConversorEuroTest {

	
	
	@Test()
	void quandoOhValorEhInvalido() {
		BigDecimal valor = BigDecimal.ZERO;
		assertThrows(ValorInvalidoException.class, ()->{
			 new Euro(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido2() {
		BigDecimal valor = new BigDecimal(0.0);
		assertThrows(ValorInvalidoException.class, ()->{
			 new Euro(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido3() {
		BigDecimal valor = null;
		assertThrows(ValorInvalidoException.class, ()->{
			 new Euro(valor);
		});
	}
	
	@Test
	void saidaFormatadaTest() {
		BigDecimal valor = new BigDecimal(100.0);
		Euro euro = new Euro(valor);
		assertEquals("100,00 €", euro.toString());
	}
	
	@Test
	void converterEuroEmReal() {
		Real real = new Real();
    	BigDecimal valor = new BigDecimal(1.00);
    	Euro euro = new Euro(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("R$ 5,34", conversorImpl.converter(euro, real).toString());
	}
	
	@Test
	void converterEuroEmDolar() {
		Moeda moeda = new Dolar();
    	BigDecimal valor = new BigDecimal(1.00);
    	Euro euro = new Euro(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("$1.10", conversorImpl.converter(euro, moeda).toString());
	}
	
	@Test
	void converterEuroEmLibrasEsterlinas() {
		Moeda moeda = new LibraEsterlina();
    	BigDecimal valor = new BigDecimal(1.00);
    	Euro euro = new Euro(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("£0.85", conversorImpl.converter(euro, moeda).toString());
	}
	
	@Test
	void converterEuroEmPesoArgentino() {
		Moeda moeda = new PesoArgentino();
    	BigDecimal valor = new BigDecimal(1.00);
    	Euro euro = new Euro(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("$ 286,29", conversorImpl.converter(euro, moeda).toString());
	}
	
	@Test
	void converterEuroEmPesoChileno() {
		Moeda moeda = new PesoChileno();
    	BigDecimal valor = new BigDecimal(1.00);
    	Euro euro = new Euro(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("$860,28", conversorImpl.converter(euro, moeda).toString());
	}

}
