package com.io.main;

import java.math.BigDecimal;

import com.io.dominio.Dolar;
import com.io.dominio.Euro;
import com.io.dominio.LibraEsterlina;
import com.io.dominio.Moeda;
import com.io.dominio.PesoArgentino;
import com.io.dominio.PesoChileno;
import com.io.dominio.Real;
import com.io.impl.ConversorImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	BigDecimal valor = new BigDecimal(10.00);
    	Moeda origem;
    	Moeda destino;
    	ConversorImpl impl = new ConversorImpl();
    	
    	System.out.println("Conversão de Real para outras moedas");
    	origem = new Real(valor);
    	destino = new Dolar();
    	
    	System.out.println("Real para Dolar " + impl.converter(origem, destino).getValor().doubleValue());
    	destino = new Euro();
    	System.out.println("Real para Euro " + impl.converter(origem, destino).getValor().doubleValue());
        destino = new LibraEsterlina();
    	System.out.println("Real para Libra " + impl.converter(origem, destino).getValor().doubleValue());
        destino = new PesoChileno();
    	System.out.println("Real para peso Chileno " + impl.converter(origem, destino).getValor().doubleValue());
        destino = new PesoArgentino();
    	System.out.println("Real para peso Argentino " + impl.converter(origem, destino).getValor().doubleValue());
    	
    	
    	System.out.println("Conversão de Dolar para outras moedas");
    	origem = new Dolar(valor);
    	destino = new Real();
    	
    	System.out.println("Dolar para Real " + impl.converter(origem, destino).getValor().doubleValue());
    	destino = new Euro();
    	System.out.println("Dolar para Euro " + impl.converter(origem, destino).getValor().doubleValue());
        destino = new LibraEsterlina();
    	System.out.println("Dolar para Libra " + impl.converter(origem, destino).getValor().doubleValue());
        destino = new PesoChileno();
    	System.out.println("Dolar para P.Chileno " + impl.converter(origem, destino).getValor().doubleValue());
        destino = new PesoArgentino();
    	System.out.println("Dolar para P.Argentino " + impl.converter(origem, destino).getValor().doubleValue());

        
    	
	}

}
