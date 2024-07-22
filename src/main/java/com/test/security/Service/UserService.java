package com.test.security.Service;

import com.test.security.dto.LoginRequestDto;
import com.test.security.dto.SignUpMemberDto;

public interface UserService {
    public String signUp(SignUpMemberDto signUpMemberDto);
    public String login(LoginRequestDto memberDTO);
}
