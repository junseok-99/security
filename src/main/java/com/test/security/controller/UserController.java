package com.test.security.controller;

import com.test.security.Service.UserService;
import com.test.security.dto.LoginRequestDto;
import com.test.security.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto memberDTO) {
        String token = userService.login(memberDTO);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
