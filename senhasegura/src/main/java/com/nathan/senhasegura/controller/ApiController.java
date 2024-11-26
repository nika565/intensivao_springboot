package com.nathan.senhasegura.controller;

import com.nathan.senhasegura.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    PasswordService passwordService;

    @PostMapping("/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest request) {

        var failures = passwordService.validatePassword(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }

}
