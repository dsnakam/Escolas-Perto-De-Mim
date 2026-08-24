package dsnakam.escolas_perto_de_mim.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EnderecoNaoEncontradoException.class)
    public ResponseEntity<String> tratarEnderecoNaoEncontrado(EnderecoNaoEncontradoException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
