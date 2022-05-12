package br.com.uniproof.integracao.userClient.service;

import br.com.uniproof.integracao.userClient.client.User;
import br.com.uniproof.integracao.userClient.client.UserResponse;
import br.com.uniproof.integracao.userClient.controllers.UserClient;
import com.jayway.jsonpath.JsonPath;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class UserService {
    @Autowired
    private UserClient userclient;
     // usa-se no UserResponse o @Builder para poder acessar o objeto e inserir os utilizar os parâmetros separadamente//
    @Cacheable("token")
    public UserResponse getLoginToken(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
    // o Json parse aqui, filtra o response, nesse caso eu pego só o message, não o body total //
        try {
            log.info("busca novo token");
            return userclient.token(user);
        } catch (FeignException ex) {
            String message = JsonPath.parse(ex.contentUTF8()).read("$.message", String.class);
            return UserResponse.builder()
                    .message(message)
                    .statusCode(ex.status())
                    .build();

        }
    }
}