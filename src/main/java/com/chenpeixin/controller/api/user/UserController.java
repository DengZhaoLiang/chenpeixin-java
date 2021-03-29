package com.chenpeixin.controller.api.user;

import com.chenpeixin.dto.api.user.LoginRequest;
import com.chenpeixin.model.User;
import com.chenpeixin.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * @author chenpeixin
 * 2021-02-10
 */
@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService mUserService;

    @PostMapping("login")
    public User login(@RequestBody @Validated LoginRequest request) {
        return mUserService.login(request);
    }

    @PostMapping("register")
    public void register(@RequestBody @Validated User user) {
        user.setCreatedAt(Instant.now().getEpochSecond());
        user.setUpdatedAt(Instant.now().getEpochSecond());
        mUserService.register(user);
    }

    @PutMapping("")
    public User updateUser(@RequestBody @Validated User user) {
        user.setUpdatedAt(Instant.now().getEpochSecond());
        return mUserService.updateUser(user);
    }

    @GetMapping("/{id}")
    public User selectUser(@PathVariable Long id) {
        return mUserService.selectUser(id);
    }
}
