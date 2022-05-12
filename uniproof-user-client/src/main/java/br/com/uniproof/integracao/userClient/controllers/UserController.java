package br.com.uniproof.integracao.userClient.controllers;

import br.com.uniproof.integracao.userClient.CacheManager.CacheConfig;
import br.com.uniproof.integracao.userClient.client.User;
import br.com.uniproof.integracao.userClient.client.UserResponse;
import br.com.uniproof.integracao.userClient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userservice;

    @Autowired
    CacheConfig cacheConfig;


    @PostMapping("/login")
    public ResponseEntity<UserResponse> getLoginToken(@RequestBody User user) {

        UserResponse userResponse = userservice.getLoginToken(user.getEmail(), user.getPassword());
        log.info("solicitado token");
        if (userResponse.getStatusCode() == null) {
            return ResponseEntity.ok(userResponse);
        } else
            log.info("falha a solicitação");
        {
            return ResponseEntity.status(userResponse.getStatusCode()).body(userResponse);
        }
    }
}
