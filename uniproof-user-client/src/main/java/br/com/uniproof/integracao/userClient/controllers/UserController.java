package br.com.uniproof.integracao.userClient.controllers;

import br.com.uniproof.integracao.userClient.client.User;
import br.com.uniproof.integracao.userClient.client.UserResponse;
import br.com.uniproof.integracao.userClient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("user")
public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping
    public UserResponse getUser(){
        return userservice.getUser();

    }



}
