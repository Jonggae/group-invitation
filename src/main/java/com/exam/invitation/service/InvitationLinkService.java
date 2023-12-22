package com.exam.invitation.service;


import com.exam.invitation.repository.InvitationLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationLinkService {

    private final InvitationLinkRepository invitationLinkRepository;
}

