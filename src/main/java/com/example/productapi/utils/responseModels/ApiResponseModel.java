package com.example.productapi.utils.responseModels;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiResponseModel {
    
    private int httpStatus;
    private String status;
    private String message;

    public ApiResponseModel(int httpStatus, String message) {
        this.setHttpStatus(httpStatus);
        this.status = "success";
        this.setMessage(message);
    }
}
