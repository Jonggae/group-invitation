package com.exam.invitation.repository;

import com.exam.invitation.domain.InvitationLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvitationLinkRepository extends JpaRepository<InvitationLink, String> {
    Optional<InvitationLink> findById(Long id);
}
