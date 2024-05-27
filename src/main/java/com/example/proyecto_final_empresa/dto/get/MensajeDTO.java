package com.example.proyecto_final_empresa.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MensajeDTO<T> {
    private HttpStatus status;
    private boolean error;
    private T message;
    private T response;
}
