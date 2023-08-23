package com.example.productapi.utils.response;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PutResponse {
    
    public static ResponseEntity<Object> putResponse(String message, HttpStatus statusCode) {
        Map<String, Object> mapResponse = new LinkedHashMap<>();
        mapResponse.put("httpStatus", statusCode.value());
        mapResponse.put("status", "success");
        mapResponse.put("message", message);

        return ResponseEntity.status(statusCode).body(mapResponse);
    }
}
