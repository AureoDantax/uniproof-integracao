package br.com.uniproof.integracao.userClient.controllers;

import br.com.uniproof.integracao.userClient.client.User;
import br.com.uniproof.integracao.userClient.client.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth", url = "${api-url}")
public interface UserClient {
    @PostMapping(value = "/api/auth")
    UserResponse token(User user);
}
