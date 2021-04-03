package com.chenpeixin.controller.api;

import com.chenpeixin.dto.api.user.LoginRequest;
import com.chenpeixin.model.User;
import com.chenpeixin.service.api.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Validated
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService mLoginService;

    @PostMapping("login")
    public User login(@RequestBody @Validated LoginRequest request) {
        return mLoginService.login(request);
    }

    @PostMapping("register")
    public void register(@RequestBody @Validated User user) {
        user.setCreatedAt(Instant.now().getEpochSecond());
        user.setUpdatedAt(Instant.now().getEpochSecond());
        mLoginService.register(user);
    }

}
