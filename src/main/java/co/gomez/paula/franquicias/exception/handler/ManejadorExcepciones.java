package co.gomez.paula.franquicias.exception.handler;

import co.gomez.paula.franquicias.exception.DatosNoEncontradosException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Log4j2
public class ManejadorExcepciones {

    @ExceptionHandler(DatosNoEncontradosException.class)
    protected ResponseEntity procesarDatosNoEncontradosException(DatosNoEncontradosException ex, WebRequest request) {
        log.error("Error invocando {}: {}", request, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        log.error("Error invocando {}: {}", request, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    protected ResponseEntity handleRuntimeException(RuntimeException ex, WebRequest request) {
        log.error("Error invocando {}: {}", request, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se ha podido procesar su solicitud. Contacte al administrador.");
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity handleUncheckedException(Throwable ex, WebRequest request) {
        log.error("Error invocando {}: {}", request, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se ha podido procesar su solicitud. Contacte al administrador.");
    }
}
