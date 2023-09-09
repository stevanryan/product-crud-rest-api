package com.example.productapi.utils.response;

import com.example.productapi.utils.responseModels.ApiResponseModel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Collections;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonPropertyOrder({ "httpStatus", "status", "message", "data" })
public class GetResponse<T> extends ApiResponseModel {

    private Object data;

    public GetResponse(HttpStatus httpStatus, String message, T data) {
        super(httpStatus.value(), message);
        this.setData(Collections.singletonMap("product", data));
    }

    public GetResponse(HttpStatus httpStatus, String message, List<T> data) {
        super(httpStatus.value(), message);
        this.setData(Collections.singletonMap("products", data));
    }
}
