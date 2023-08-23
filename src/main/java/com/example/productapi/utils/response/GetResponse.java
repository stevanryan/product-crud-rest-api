package com.example.productapi.utils.response;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetResponse {

    public static ResponseEntity<Object> getResponse(Object data, HttpStatus statusCode) {
        Map<String, Object> mapResponse = new LinkedHashMap<>();
        mapResponse.put("httpStatus", statusCode.value());
        mapResponse.put("status", "success");
        mapResponse.put("data", data);

        return ResponseEntity.status(statusCode).body(mapResponse);
    }

    public static <E> ResponseEntity<Object> getAllResponse(List<E> data, HttpStatus statusCode) {
        Map<String, Object> mapResponse = new LinkedHashMap<>();
        mapResponse.put("httpStatus", statusCode.value());
        mapResponse.put("status", "success");
        mapResponse.put("data", data);

        return ResponseEntity.status(statusCode).body(mapResponse);
    }
}
