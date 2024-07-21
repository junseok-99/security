package com.test.security.Repository;

import com.test.security.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member findMemberById(String id);
}
