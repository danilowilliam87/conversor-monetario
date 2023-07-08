package com.io.main;

import java.math.BigDecimal;

import com.io.dominio.Dolar;
import com.io.dominio.Real;
import com.io.impl.ConversorImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Real real = new Real();
    	BigDecimal valor = new BigDecimal(1.00);
    	Dolar dolar = new Dolar(valor);
    	ConversorImpl conversorImpl = new ConversorImpl();
    	
    	System.out.println(conversorImpl.converter(dolar, real));

	}

}
