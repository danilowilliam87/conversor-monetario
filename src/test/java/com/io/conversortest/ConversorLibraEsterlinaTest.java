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
		LibraEsterlina le = new LibraEsterlina(valor);
		Moeda moeda = new Real();
		ConversorImpl impl = new ConversorImpl();
		String retorno = impl.converter(le, moeda).toString();
		assertEquals("R$ 62,55", retorno);
	}
	
	@Test
	void converterLibraEsterlinaParaDolar() {
		BigDecimal valor = new BigDecimal(10.0);
		LibraEsterlina le = new LibraEsterlina(valor);
		Moeda moeda = new Dolar();
		ConversorImpl impl = new ConversorImpl();
		String retorno = impl.converter(le, moeda).toString();
		assertEquals("$12.84", retorno);
	}
	
	@Test
	void converterLibraEsterlinaParaEuro() {
		BigDecimal valor = new BigDecimal(10.0);
		LibraEsterlina le = new LibraEsterlina(valor);
		Moeda moeda = new Euro();
		ConversorImpl impl = new ConversorImpl();
		String retorno = impl.converter(le, moeda).toString();
		assertEquals("11,70 €", retorno);
	}
	
	

}
