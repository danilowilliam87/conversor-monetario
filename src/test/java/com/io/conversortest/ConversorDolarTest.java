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
    	BigDecimal valor = new BigDecimal(10.00);
    	Moeda origem = new Dolar(valor);
    	Moeda destino = new Real();
    	ConversorImpl conversorImpl = new ConversorImpl();
    	double valorFinal = conversorImpl.converter(origem, destino).getValor().doubleValue();
    	assertEquals(48.715, valorFinal, 0.001);
    }
	
	
	@Test
    void converterDolarEmEuroTest() {
		BigDecimal valor = new BigDecimal(10.00);
    	Moeda origem = new Dolar(valor);
    	Moeda destino = new Euro();
    	ConversorImpl conversorImpl = new ConversorImpl();
    	double valorFinal = conversorImpl.converter(origem, destino).getValor().doubleValue();
    	assertEquals(9.116, valorFinal, 0.001);
    }
	
	@Test
    void converterDolarEmLibrasEsterlinasTest() {
		BigDecimal valor = new BigDecimal(10.00);
    	Moeda origem = new Dolar(valor);
    	Moeda destino = new LibraEsterlina();
    	ConversorImpl conversorImpl = new ConversorImpl();
    	double valorFinal = conversorImpl.converter(origem, destino).getValor().doubleValue();
    	assertEquals(7.786, valorFinal, 0.001);
    }
	
	
	@Test
    void converterDolarEmPesoArgentinoTest() {
		BigDecimal valor = new BigDecimal(10.00);
    	Moeda origem = new Dolar(valor);
    	Moeda destino = new PesoArgentino();
    	ConversorImpl conversorImpl = new ConversorImpl();
    	double valorFinal = conversorImpl.converter(origem, destino).getValor().doubleValue();
    	assertEquals(2609.581, valorFinal, 0.001);
    }
	
	@Test
    void converterDolarEmPesoChilenoTest() {
		BigDecimal valor = new BigDecimal(10.00);
    	Moeda origem = new Dolar(valor);
    	Moeda destino = new PesoChileno();
    	ConversorImpl conversorImpl = new ConversorImpl();
    	double valorFinal = conversorImpl.converter(origem, destino).getValor().doubleValue();
    	assertEquals(8070.2, valorFinal, 0.001);
    }

}
