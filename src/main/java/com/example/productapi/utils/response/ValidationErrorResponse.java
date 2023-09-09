package com.example.productapi.utils.response;

import com.example.productapi.utils.responseModels.ApiResponseModel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonPropertyOrder({ "httpStatus", "status", "message" })
public class ValidationErrorResponse extends ApiResponseModel {

    private List<String> errors;

    public ValidationErrorResponse(HttpStatus httpStatus, String message, List<String> errors) {
        super(httpStatus.value(), "fail", message);
        this.setErrors(errors);
    }
}
