package com.exam.invitation.repository;

import com.exam.invitation.domain.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * 그룹에 초대될 인원들에대한 repository
 * 임시 회원이었다가 활성화 되는 방향*/
public interface TempMemberRepository extends JpaRepository<TempMember, Long> {
    Optional<TempMember> findById(Long id);

    Optional<TempMember> findByName(String name);

    Optional<TempMember> findByPhoneNumber(String phoneNumber);

    Optional<TempMember> findByEmail(String email);

}
