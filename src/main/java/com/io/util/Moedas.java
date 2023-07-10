/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.io.util;



/**
 *
 * @author Danil
 */
public class Moedas {
    
    private static String [] moedas;
    
    public static void carregar(){
        moedas = new String[6];
        moedas[0] = "Real";
        moedas[1] = "Euro";
        moedas[2] = "Dolar";
        moedas[3] = "Libra Esterlina";
        moedas[4] = "Peso Argentino";
        moedas[5] = "Peso Chileno";
    }
    
    public static String[] obterMoedas(){
        carregar();
        return moedas;
    }
    
}
