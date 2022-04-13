package br.com.uniproof.integracao.userClient.controllers;

import br.com.uniproof.integracao.userClient.client.User;
import br.com.uniproof.integracao.userClient.client.UserResponse;
import br.com.uniproof.integracao.userClient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> getLoginToken(@RequestBody User user)  {

        UserResponse userResponse = userservice.getLoginToken(user.getEmail(), user.getPassword());
        if (userResponse.getStatusCode() == null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.status(userResponse.getStatusCode()).body(userResponse);
        }
    }
}
