package com.test.security.Service;

import com.test.security.dto.LoginRequestDto;

public interface UserService {
    public String login(LoginRequestDto memberDTO);
}
