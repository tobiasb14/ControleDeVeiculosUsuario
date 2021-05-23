package br.com.zup.controleDeUsuarioVeiculos.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class IdNaoEncontradoHandler {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResponseStatusException.class)
	public String handler(ResponseStatusException e) {
		
		String mensagem = e.getReason();
		return mensagem;
	}
}
