package com.example.ecomweb.dto.user;

public class SignInResponseDTO {

    private String status;
    private String token;

    public SignInResponseDTO() {
    }

    public SignInResponseDTO(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SignInResponseDTO{" +
                "status='" + status + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
