package br.com.pscs.reginprocessoservice.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.pscs.reginprocessoservice.model.ResponseExceptionAdapter;

@ControllerAdvice
public class RespostaExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<ResponseExceptionAdapter> handlerConflict(RuntimeException exception , WebRequest request){
		ResponseExceptionAdapter exceptionAdapter = new ResponseExceptionAdapter();
		exceptionAdapter.setMessage(exception.getMessage());
		exceptionAdapter.setTimestamp(LocalDateTime.now());
		exceptionAdapter.setDescription(request.getDescription(false));
		return new ResponseEntity<ResponseExceptionAdapter>(exceptionAdapter,HttpStatus.BAD_REQUEST);
	}

}
