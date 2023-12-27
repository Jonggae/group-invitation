package com.exam.invitation.service;


import com.exam.invitation.domain.TempMember;
import com.exam.invitation.repository.InvitationLinkRepository;
import com.exam.invitation.repository.TempMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationLinkService {

    private final InvitationLinkRepository invitationLinkRepository;
    private final TempMemberRepository tempMemberRepository;

    // 무작위의 1회용 링크 생성
    public String generateInvitationLink() {

        UUID uuid = UUID.randomUUID();

        String randomLink = uuid.toString()
                .replace("-", "");
        /*하이픈 제거하지 않으면 f8c804bc-63e2-4c84-b7d6-fa38c19e4803 이런식으로 생성*/

        return "https://testdomain.com/invitaion/" + randomLink;
        // 하드코딩말고 도메인을 따로 관리하는것이 좋음.

    }

    // 링크가 수락되었을 때 로직
    public void acceptInvitationLink(Long id) {
        // 이름으로 찾음 -> TODO 이름은 중복일 수 있는데 어떻게 할지 고려
        // TempMember 가 저장될때 생성된 id를 사용하자

        TempMember activateMember = tempMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        // 멤버를 찾았으면 활성화 시킴
        activateMember.activate();
        tempMemberRepository.save(activateMember);

        // TODO 이미 활성화 되어있다면? -> 에러 메시지

    }

}

