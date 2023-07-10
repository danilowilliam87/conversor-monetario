package com.io.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.excecao.UtilException;

/**
 * @author Danilo William
 * classe utilit�ria para convers�o do json em objeto
 */
public class JsonUtil {
	
	/**
	 * 
	 * @param json
	 * @return DadosRetornoAPi
	 * metodo que converte o json em objeto
	 */
	public static DadosRetornoApi converterJsonParaObjeto(String json) {
		ObjectMapper mapper = new ObjectMapper();
		DadosRetornoApi api = new DadosRetornoApi();
		try {
			api =  mapper.readValue(json, DadosRetornoApi.class);
			return api;
		} catch (Exception e) {
			throw new UtilException("Erro ao aplicar formatacao : " + e.getMessage());
		}
	}
	
	
	
	

}
