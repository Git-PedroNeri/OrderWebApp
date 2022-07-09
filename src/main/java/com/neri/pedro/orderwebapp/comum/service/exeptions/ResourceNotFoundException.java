package com.neri.pedro.orderwebapp.comum.service.exeptions;

/**
 * @Created 09/07/2022 - 15:49
 * @Author pedro.neri
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object o) {
        super("Resource not found: "+o);
    }
}
