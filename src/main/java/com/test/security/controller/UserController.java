package com.test.security.controller;

import com.test.security.Service.UserService;
import com.test.security.dto.LoginRequestDto;
import com.test.security.dto.Member;
import com.test.security.dto.SignUpMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @PreAuthorize("hasRole('ROLE_Basic')")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto memberDTO) {
        String token = userService.login(memberDTO);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpMemberDto memberDTO) {
        userService.signUp(memberDTO);
        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }
}
