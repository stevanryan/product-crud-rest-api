package com.example.productapi.utils.response;

import com.example.productapi.utils.responseModels.ApiResponseModel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;

@JsonPropertyOrder({ "httpStatus", "status", "message" })
public class DeleteResponse extends ApiResponseModel {
    
    public DeleteResponse(HttpStatus httpStatus, String message) {
        super(httpStatus.value(), message);
    }
}
