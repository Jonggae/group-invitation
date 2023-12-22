package com.exam.invitation.repository;

import com.exam.invitation.domain.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TempMemberRepository extends JpaRepository<TempMember, Long> {
    Optional<TempMember> findById(Long id);

    Optional<TempMember> findByName(String name);

    Optional<TempMember> findByPhoneNumber(String phoneNumber);

    Optional<TempMember> findByEmail(String email);

    List<TempMember> findAll();
}
