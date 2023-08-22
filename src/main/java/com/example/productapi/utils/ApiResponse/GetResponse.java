package com.example.productapi.utils.ApiResponse;

public class GetResponse {
    private String status;
    private Object data;

    public GetResponse() {}

    public GetResponse(String status, Object data) {
        this.setStatus(status);
        this.setData(data);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}
