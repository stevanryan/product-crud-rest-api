package com.example.productapi.utils.response;

import com.example.productapi.utils.responseModels.ApiResponseModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;
import java.util.Collections;

import org.springframework.http.HttpStatus;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@JsonPropertyOrder({ "httpStatus", "status", "message", "data" })
public class PostResponse extends ApiResponseModel {
    
    private Map<String, Object> data;
    
    public PostResponse(HttpStatus httpStatus, String message, String idType, Long id) {
        super(httpStatus.value(), message);
        this.setData(Collections.singletonMap(idType, id));
    }
}
