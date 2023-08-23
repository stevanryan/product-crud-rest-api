package com.example.productapi.utils.response;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PostResponse {

    public static ResponseEntity<Object> postResponse(String message, String idType, Long id, HttpStatus statusCode) {
        Map<String, Object> mapResponse = new LinkedHashMap<>();
        mapResponse.put("httpStatus", statusCode.value());
        mapResponse.put("status", "success");
        mapResponse.put("message", message);
        mapResponse.put(idType, id);

        return ResponseEntity.status(statusCode).body(mapResponse);
    }
}
