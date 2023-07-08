package com.io.util;

import java.text.NumberFormat;
import java.util.Locale;


/**
 * @author Danilo Wiliam
 * classe Utilitaria para formatacao 
 * de valores
 */
public class StringFormatUtils {
	
	/**
	 * 
	 * @param json
	 * @return String
	 * realizar formata��o do json
	 */
	public static String formatar(String json) {
		try {
			int indice = json.indexOf(":");
			return json.substring(indice + 1);
		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao aplicar formatacao : " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param valor
	 * @param idioma
	 * @param pais
	 * @return String
	 * 
	 * realiza formata��o de valores monetarios
	 */
	public static String formatar(double valor, String idioma, String pais) {
		try {
			Locale locale = new Locale(idioma, pais);
			NumberFormat formato = NumberFormat.getCurrencyInstance(locale);
			formato.setMinimumFractionDigits(2);
			formato.setMaximumFractionDigits(2);
			return formato.format(valor);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao aplicar formatacao : " + e.getMessage());
		}
	}
        /**
         * 
         * @param valor
         * @param novoLocale
         * @return String
         * 
         * realiza formata��o de valores monetarios
         */
        public static String formatar(double valor, Locale novoLocale) {
		try {
			Locale locale = novoLocale;
			NumberFormat formato = NumberFormat.getCurrencyInstance(locale);
			formato.setMinimumFractionDigits(2);
			formato.setMaximumFractionDigits(2);
			return formato.format(valor);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao aplicar formatacao : " + e.getMessage());
		}
	}
        

}
