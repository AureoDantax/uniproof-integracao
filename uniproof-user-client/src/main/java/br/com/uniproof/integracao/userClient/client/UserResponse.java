package br.com.uniproof.integracao.userClient.client;

import lombok.Data;

@Data
public class UserResponse {
    private Integer statuscode;
    private String message;
    private String token;
    private String companyToken;
    private Integer termsOfUseVersion;
}
