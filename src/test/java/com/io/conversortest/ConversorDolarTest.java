package com.io.conversortest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.io.dominio.Dolar;
import com.io.dominio.Euro;
import com.io.dominio.LibraEsterlina;
import com.io.dominio.PesoArgentino;
import com.io.dominio.PesoChileno;
import com.io.dominio.Real;
import com.io.excecao.ValorInvalidoException;
import com.io.impl.ConversorImpl;

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
	
	@Test
    void converterDolarEmRealTest() {
    	Real real = new Real();
    	BigDecimal valor = new BigDecimal(1.00);
    	Dolar dolar = new Dolar(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("R$ 4,87", conversorImpl.converter(dolar, real).toString());
    }
	
	
	@Test
    void converterDolarEmEuroTest() {
    	Euro euro = new Euro();
    	BigDecimal valor = new BigDecimal(1.00);
    	Dolar dolar = new Dolar(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("0,91 €", conversorImpl.converter(dolar, euro).toString());
    }
	
	@Test
    void converterDolarEmLibrasEsterlinasTest() {
    	LibraEsterlina lb = new LibraEsterlina();
    	BigDecimal valor = new BigDecimal(1.00);
    	Dolar dolar = new Dolar(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("£0.78", conversorImpl.converter(dolar, lb).toString());
    }
	
	
	@Test
    void converterDolarEmPesoArgentinoTest() {
    	PesoArgentino pa = new PesoArgentino();
    	BigDecimal valor = new BigDecimal(1.00);
    	Dolar dolar = new Dolar(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("$ 260,96", conversorImpl.converter(dolar, pa).toString());
    }
	
	@Test
    void converterDolarEmPesoChilenoTest() {
    	PesoChileno pc = new PesoChileno();
    	BigDecimal valor = new BigDecimal(1.00);
    	Dolar dolar = new Dolar(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	assertEquals("$807,02", conversorImpl.converter(dolar, pc).toString());
    }

}
