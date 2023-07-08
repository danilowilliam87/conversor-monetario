package com.io.main;

import java.math.BigDecimal;

import com.io.dominio.Dolar;
import com.io.dominio.LibraEsterlina;
import com.io.dominio.PesoChileno;
import com.io.impl.ConversorImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	BigDecimal valor = new BigDecimal(1.00);
    	Dolar dolar = new Dolar(valor);
    	PesoChileno pc = new PesoChileno();
    	LibraEsterlina lb = new LibraEsterlina();
    	ConversorImpl conversorImpl = new ConversorImpl();
    	
    	System.out.println(conversorImpl.converter(dolar, pc));

	}

}
