package com.exam.invitation.repository;

import com.exam.invitation.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * 그룹에 초대될 인원들에대한 repository
 * 임시 회원이었다가 활성화 되는 방향*/
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    Optional<Member> findByPhoneNumber(String phoneNumber);

    Optional<Member> findByEmail(String email);

}
