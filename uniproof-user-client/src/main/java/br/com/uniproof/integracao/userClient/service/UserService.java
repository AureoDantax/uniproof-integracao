package br.com.uniproof.integracao.userClient.service;

import br.com.uniproof.integracao.userClient.client.User;
import br.com.uniproof.integracao.userClient.client.UserResponse;
import br.com.uniproof.integracao.userClient.controllers.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserClient userclient;

    public UserResponse getUser() {
        User user = User.builder()
                .email("user2@uniproof.com.br")
                .password("10203040")
                .build();
        UserResponse useresponse = userclient.token(user);
        return useresponse;
    }
}
