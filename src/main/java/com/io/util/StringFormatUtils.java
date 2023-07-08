package com.io.util;

import com.io.excecao.UtilException;


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
			throw new UtilException("Erro ao aplicar formatacao : " + e.getMessage());
		}
	}
}
