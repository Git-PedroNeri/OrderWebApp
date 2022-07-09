package com.neri.pedro.orderwebapp.comum.service.exeptions;

import lombok.Data;

import java.time.Instant;

/**
 * @Created 09/07/2022 - 15:49
 * @Author pedro.neri
 */
@Data
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
