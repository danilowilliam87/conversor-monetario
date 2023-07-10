package com.io.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.io.excecao.UtilException;

/**
 * @author Danilo William
 * classe que realizar a chamada REST
 * pra obter os valores das cota��es
 */
public class RestUtil {
	
	 
	 /**
	  * 
	  * @param url
	  * @return String
	  * retorna um json com os dados da cota��o
	  */
	 public static String get(String url) {
		 
		 try {
		    HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest
					.newBuilder()
					.GET()
					.header("Content-Type", "application/json")
					.timeout(Duration.ofSeconds(15))
					.uri(URI.create(url))
					.build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return String.valueOf(response.body());
		} catch (Exception e) {
			throw new UtilException("Erro ao aplicar formatacao : " + e.getMessage());
		}
	 }
	

}
