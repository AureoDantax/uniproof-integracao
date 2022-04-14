package br.com.uniproof.integracao.userClient.client;

import com.fasterxml.jackson.annotation.JsonInclude.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private Integer statusCode;
    private String message;
    private String token;
    private String companyToken;
    private Integer termsOfUseVersion;

}
