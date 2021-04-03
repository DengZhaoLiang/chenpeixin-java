package com.chenpeixin.controller.api.admin;

import com.chenpeixin.dto.api.admin.PasswordRequest;
import com.chenpeixin.model.User;
import com.chenpeixin.service.api.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService mAdminService;

    @PutMapping("")
    public User updateUser(@RequestBody @Validated User user) {
        user.setUpdatedAt(Instant.now().getEpochSecond());
        return mAdminService.updateAdmin(user);
    }

    @GetMapping("/{id}")
    public User selectUser(@PathVariable Long id) {
        return mAdminService.selectAdmin(id);
    }

    @PutMapping("/change/password")
    public void changePassword(@RequestBody @Validated PasswordRequest request) {
        mAdminService.changePassword(request);
    }
}
