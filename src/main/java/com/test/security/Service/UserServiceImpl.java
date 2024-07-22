package com.test.security.Service;

import com.test.security.Repository.MemberRepository;
import com.test.security.dto.LoginRequestDto;
import com.test.security.dto.Member;
import com.test.security.dto.MemberInfoDto;
import com.test.security.dto.SignUpMemberDto;
import com.test.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JwtUtil jwtUtil;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String signUp(SignUpMemberDto signUpMemberDto) {
        System.out.println("DTO = " + signUpMemberDto);
        return memberRepository.save(new Member(
            signUpMemberDto.getId(),
            passwordEncoder.encode(signUpMemberDto.getPassword()),
            "Basic")
        ).getId();
    }

    @Override
    public String login(LoginRequestDto memberDTO) {
        String id = memberDTO.getId();
        String password = memberDTO.getPassword();
        Member member = memberRepository.findMemberById(id);

        if (member == null) {
            throw new UsernameNotFoundException("아이디가 존재하지 않습니다.");
        }

        //암호화된 password를 Decoding한 값과 입력한 password 값이 다르면 null 반환
        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        MemberInfoDto memberInfoDto = new MemberInfoDto();
        memberInfoDto.setId(member.getId());
        memberInfoDto.setPassword(member.getPassword());
        memberInfoDto.setRole(member.getRole());

        String accessToken = jwtUtil.createAccessToken(memberInfoDto);
        return accessToken;
    }
}
