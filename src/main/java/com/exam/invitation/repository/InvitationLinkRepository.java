package com.exam.invitation.repository;

import com.exam.invitation.domain.InvitationLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
* 초대 링크와 관련된 repository
* 링크의 id 를 찾아서 조회 가능*/
public interface InvitationLinkRepository extends JpaRepository<InvitationLink, String> {
    Optional<InvitationLink> findById(Long id);
}
