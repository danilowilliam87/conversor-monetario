package com.io.conversortest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.io.dominio.Real;
import com.io.excecao.ValorInvalidoException;

class ConversorRealTest {

	
	
	@Test()
	void quandoOhValorEhInvalido() {
		BigDecimal valor = BigDecimal.ZERO;
		assertThrows(ValorInvalidoException.class, ()->{
			 new Real(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido2() {
		BigDecimal valor = new BigDecimal(0.0);
		assertThrows(ValorInvalidoException.class, ()->{
			 new Real(valor);
		});
	}
	
	@Test()
	void quandoOhValorEhInvalido3() {
		BigDecimal valor = null;
		assertThrows(ValorInvalidoException.class, ()->{
			 new Real(valor);
		});
	}
	
	@Test
	void saidaFormatadaTest() {
		BigDecimal valor = new BigDecimal(100.0);
		Real real = new Real(valor);
		assertEquals("R$ 100,00", real.toString());
	}

}
