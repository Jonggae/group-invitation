package com.exam.invitation.service;


import com.exam.invitation.repository.InvitationLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationLinkService {

    private final InvitationLinkRepository invitationLinkRepository;

    // 무작위의 1회용 링크 생성
    public String generateInvitationLink() {

        UUID uuid = UUID.randomUUID();

        String randomLink = uuid.toString()
                .replace("-", "");
        /*
                하이픈 제거하지 않으면 f8c804bc-63e2-4c84-b7d6-fa38c19e4803 이런식으로 생성*/

        return "https://testdomain.com/invitaion/" + randomLink;

    }
}

