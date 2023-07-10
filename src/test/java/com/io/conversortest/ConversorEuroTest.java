package com.io.conversortest;



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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		BigDecimal valor = new BigDecimal(10.00);
		Moeda origem = new Euro(valor);
		Moeda destino = new Real();
		ConversorImpl impl = new ConversorImpl();
		double valorFinal = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(53.412, valorFinal, 0.001);
	}
	
	@Test
	void converterEuroEmDolar() {
		BigDecimal valor = new BigDecimal(10.00);
		Moeda origem = new Euro(valor);
		Moeda destino = new Dolar();
		ConversorImpl impl = new ConversorImpl();
		double valorFinal = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(10.967, valorFinal, 0.001);
	}
	
	@Test
	void converterEuroEmLibrasEsterlinas() {
		BigDecimal valor = new BigDecimal(10.00);
		Moeda origem = new Euro(valor);
		Moeda destino = new LibraEsterlina();
		ConversorImpl impl = new ConversorImpl();
		double valorFinal = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(8.543, valorFinal, 0.001);
	}
	
	@Test
	void converterEuroEmPesoArgentino() {
		BigDecimal valor = new BigDecimal(10.00);
		Moeda origem = new Euro(valor);
		Moeda destino = new PesoArgentino();
		ConversorImpl impl = new ConversorImpl();
		double valorFinal = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(2862.851, valorFinal, 0.001);
	}
	
	@Test
	void converterEuroEmPesoChileno() {
		BigDecimal valor = new BigDecimal(10.00);
		Moeda origem = new Euro(valor);
		Moeda destino = new PesoChileno();
		ConversorImpl impl = new ConversorImpl();
		double valorFinal = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(8602.8, valorFinal, 0.001);
	}

}
