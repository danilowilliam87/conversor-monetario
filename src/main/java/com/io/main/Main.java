package com.io.main;

import java.math.BigDecimal;

import com.io.dominio.Dolar;
import com.io.dominio.Euro;
import com.io.dominio.LibraEsterlina;
import com.io.dominio.PesoArgentino;
import com.io.dominio.PesoChileno;
import com.io.dominio.Real;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal valor = new BigDecimal(100.0);
		Real real = new Real(valor);
		Euro euro = new Euro(valor);
		Dolar dolar = new Dolar(valor);
		PesoChileno chileno = new PesoChileno(valor);
		PesoArgentino argentino = new PesoArgentino(valor);
		LibraEsterlina esterlina = new LibraEsterlina(valor);
		
//		System.out.println(real);
//		System.out.println(real.getSigla());
//		System.out.println(valor.doubleValue());
		System.out.println(argentino);
//		System.out.println(chileno);
//		System.out.println(dolar);
//		System.out.println(euro);
		System.out.println(esterlina);

	}

}
