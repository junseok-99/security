package com.test.security.util.securityUtil;

import com.test.security.Repository.MemberRepository;
import com.test.security.dto.Member;
import com.test.security.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저 존재하지 않음"));

        MemberInfoDto memberDto = new MemberInfoDto(member.getId(), member.getPassword(), member.getRole());

        return new CustomUserDetails(memberDto);
    }
}
