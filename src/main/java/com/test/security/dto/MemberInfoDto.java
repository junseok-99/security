package com.test.security.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberInfoDto {
    private String id;
    private String password;
    private String role;
}
