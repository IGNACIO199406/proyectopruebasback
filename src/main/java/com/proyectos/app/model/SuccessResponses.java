package com.proyectos.app.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SuccessResponses {

    public static ResponseEntity<Object> ok(Object object) {
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<Object>(object, status);
    }

    public static ResponseEntity<Object> created(Object object) {
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<Object>(object, status);
    }
    
    public static ResponseEntity<Object> notFound(Object object) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<Object>(object, status);
    }
    
    public static ResponseEntity<Object> error(Object object) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<Object>(object, status);
    }

}
