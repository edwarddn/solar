package br.com.triersistemas.solar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_IMPLEMENTED)
public class NotImplementedException extends RuntimeException {

    public NotImplementedException() {
        super("Método não implementado");
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }
}
