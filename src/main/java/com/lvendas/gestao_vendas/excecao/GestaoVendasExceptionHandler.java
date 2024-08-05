package com.lvendas.gestao_vendas.excecao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GestaoVendasExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String CONSTANT_VALIDATION_NOTBLANK = "NotBlank";
    private static final String CONSTANT_VALIDATION_NOT_NULL = "NotNull";
    private static final String CONSTANT_VALIDATION_LENGTH = "Length";

    @Override
    protected Mono<ResponseEntity<Object>> handleMethodNotAllowedException(MethodNotAllowedException ex,
       HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        return super.handleMethodNotAllowedException (ex, headers, HttpStatus.BAD_REQUEST, exchange);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
      public ResponseEntity<Object> handleEmptyResultDataAcessException(EmptyResultDataAccessException ex, WebRequest request){
          String msgUsuario = "Recurso não encontrado.";
          String msgDesenvolvedor = ex.toString ();
          List<Error> errors = Arrays.asList (new Error (msgUsuario, msgDesenvolvedor));
          return handleExceptionInternal (ex, errors, new HttpHeaders (), HttpStatus.NOT_FOUND, request);
      }

    private ResponseEntity<Object> handleExceptionInternal(EmptyResultDataAccessException ex, List<Error> errors, HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest request) {
        return null;
    }

    @ExceptionHandler(RegraNegocioException.class)
      public ResponseEntity<Object> handleRegraNegocioException( RegraNegocioException ex, WebRequest request) {
         String msgUsuario = ex.getMessage ();
         String msgDesenvolvedor = ex.getMessage ();
         List<Error> errors = Arrays.asList (new Error (msgUsuario, msgDesenvolvedor));
         return handleExceptionInternal (ex, errors, new HttpHeaders (), HttpStatus.BAD_REQUEST, request);
      }

    private ResponseEntity<Object> handleExceptionInternal(RegraNegocioException ex, List<Error> errors,
         HttpHeaders   headers, HttpStatus httpStatus, WebRequest request) {
        return null;
    }

    private List<Error> gerarListaDeError(BindingResult bindingResult) {
            List<Error> errors = new ArrayList<Error> ();
            bindingResult.getFieldErrors ().forEach (fieldError -> {
            String msgUsuario = tratarMensagemDeErroParaUsuario (fieldError);
            String msgDesenvolvedor = fieldError.toString ();
            errors.add (new Error (msgUsuario, msgDesenvolvedor));
            });
           return errors;
    }
    private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {
        if (fieldError.getCode ().equals (CONSTANT_VALIDATION_NOTBLANK)) {
            return fieldError.getDefaultMessage ().concat ("É obrigatorio.");
        }

        if (fieldError.getCode ().equals (CONSTANT_VALIDATION_NOT_NULL)) {
                return fieldError.getDefaultMessage ().concat ("É obrigatorio.");
            }
        if (fieldError.getCode ().equals ("Length")) {
            return fieldError.getDefaultMessage ().concat (String.format ("Deve ter entre %x e %s caracteres",
           fieldError.getArguments ()[2], fieldError.getArguments ()[1]));
        }
        return fieldError.toString ();
    }
}





