package com.test.security.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseDto {

    private int codeNumber;
    private String errorMessage;
    private LocalDateTime time;
}
