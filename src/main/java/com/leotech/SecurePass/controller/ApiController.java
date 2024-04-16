package com.leotech.SecurePass.controller;

import com.leotech.SecurePass.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {


    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }


    @PostMapping(value = "validate-password")
    public ResponseEntity<List<String>> validatePassword(@RequestBody BodyRequest request) {

        var failures = passwordService.validate(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(failures);

    }

}
