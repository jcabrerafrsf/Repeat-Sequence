package com.possumus.repeatsequence.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.possumus.repeatsequence.util.ExcepcionParser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO for managing the response of the api.
 * @author jcabrera
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO implements Serializable {

    private boolean success;
    private Object data;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Buenos_Aires")
    private Date date = new Date();

    private List<String> errores;

    public ResponseDTO(boolean success, Object data, String message, Exception e) {
        this.success = success;
        this.data = data;

        List<String> errores = null;
        if(e != null) {
            errores = new ArrayList<>();
            errores.add(ExcepcionParser.getRootException(e).getMessage());
        }

        this.setMessage(message);
        this.setErrores(errores);
    }

}
