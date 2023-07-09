package com.io.conversortest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.io.dominio.Dolar;
import com.io.dominio.Euro;
import com.io.dominio.LibraEsterlina;
import com.io.dominio.Moeda;
import com.io.dominio.Real;
import com.io.excecao.ValorInvalidoException;
import com.io.impl.ConversorImpl;

class ConversorLibraEsterlinaTest {

	
	
	@Test()
	void quandoOhValorEhInvalido() {
		BigDecimal valor = BigDecimal.ZERO;
		assertThrows(ValorInvalidoException.class, ()->{
			 new LibraEsterlina(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido2() {
		BigDecimal valor = new BigDecimal(0.0);
		assertThrows(ValorInvalidoException.class, ()->{
			 new LibraEsterlina(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido3() {
		BigDecimal valor = null;
		assertThrows(ValorInvalidoException.class, ()->{
			 new LibraEsterlina(valor);
		});
	}
	
	@Test
	void saidaFormatadaTest() {
		BigDecimal valor = new BigDecimal(100.0);
		LibraEsterlina le = new LibraEsterlina(valor);
		assertEquals("£100.00", le.toString());
	}
	
	@Test
	void converterLibraEsterlinaParaReal() {
		BigDecimal valor = new BigDecimal(10.0);
		Moeda origem = new LibraEsterlina(valor);
		Moeda destino = new Real();
		ConversorImpl impl = new ConversorImpl();
		double retorno = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(62.546, retorno, 0.001);
	}
	
	@Test
	void converterLibraEsterlinaParaDolar() {
		BigDecimal valor = new BigDecimal(10.0);
		Moeda origem = new LibraEsterlina(valor);
		Moeda destino = new Dolar();
		ConversorImpl impl = new ConversorImpl();
		double retorno = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(12.836, retorno, 0.001);
	}
	
	@Test
	void converterLibraEsterlinaParaEuro() {
		BigDecimal valor = new BigDecimal(10.0);
		Moeda origem = new LibraEsterlina(valor);
		Moeda destino = new Euro();
		ConversorImpl impl = new ConversorImpl();
		double retorno = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(11.703, retorno, 0.001);
	}
	
	

}
