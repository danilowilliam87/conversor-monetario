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
	
	@Test
	void converterParaDolar() {
		BigDecimal bigDecimal = new BigDecimal(10.00);
		Moeda origem = new Real(bigDecimal);
		Moeda destino = new Dolar();
		ConversorImpl impl = new ConversorImpl();
		double total = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(2.052, total, 0.01);
	}
	
	@Test
	void converterParaEuro() {
		BigDecimal bigDecimal = new BigDecimal(10.00);
		Moeda origem = new Real(bigDecimal);
		Moeda destino = new Euro();
		ConversorImpl impl = new ConversorImpl();
		double total = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(1.87, total, 0.01);
	}
	
	@Test
	void converterParaLibra() {
		BigDecimal bigDecimal = new BigDecimal(10.00);
		Moeda origem = new Real(bigDecimal);
		Moeda destino = new LibraEsterlina();
		ConversorImpl impl = new ConversorImpl();
		double total = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(1.5979999999999999, total, 0.001);
	}
	
	@Test
	void converterParaPesoArgentino() {
		BigDecimal bigDecimal = new BigDecimal(10.00);
		Moeda origem = new Real(bigDecimal);
		Moeda destino = new PesoArgentino();
		ConversorImpl impl = new ConversorImpl();
		double total = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(535.432, total, 0.001);
	}
	
	@Test
	void converterParaPesoChileno() {
		BigDecimal bigDecimal = new BigDecimal(10.00);
		Moeda origem = new Real(bigDecimal);
		Moeda destino = new PesoChileno();
		ConversorImpl impl = new ConversorImpl();
		double total = impl.converter(origem, destino).getValor().doubleValue();
		assertEquals(1655.3899999999999, total, 0.001);
	}

}
