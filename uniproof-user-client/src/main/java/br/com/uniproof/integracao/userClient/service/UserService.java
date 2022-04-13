package br.com.uniproof.integracao.userClient.service;

import br.com.uniproof.integracao.userClient.client.User;
import br.com.uniproof.integracao.userClient.client.UserResponse;
import br.com.uniproof.integracao.userClient.controllers.UserClient;
import com.jayway.jsonpath.JsonPath;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserClient userclient;

    public UserResponse getLoginToken(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        try {
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