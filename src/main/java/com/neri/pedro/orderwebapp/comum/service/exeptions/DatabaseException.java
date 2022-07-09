package com.neri.pedro.orderwebapp.comum.service.exeptions;

/**
 * @Created 09/07/2022 - 16:20
 * @Author pedro.neri
 */
public class DatabaseException extends RuntimeException {


    public DatabaseException(String msg) {
        super(msg);
    }
}
