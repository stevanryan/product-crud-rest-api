package com.example.productapi.utils.response;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteResponse {
    
    public static ResponseEntity<Object> deleteResponse(String message, HttpStatus statusCode) {
        Map<String, Object> mapResponse = new LinkedHashMap<>();
        mapResponse.put("httpStatus", statusCode.value());
        mapResponse.put("message", message);

        return ResponseEntity.status(statusCode).body(mapResponse);
    }
}
