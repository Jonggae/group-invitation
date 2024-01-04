package com.exam.invitation.service;


import com.exam.invitation.domain.Member;
import com.exam.invitation.repository.InvitationLinkRepository;
import com.exam.invitation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationLinkService {

    @Value("${server.invitation.link.base-url}")
    private String baseUrl;

    private final MemberRepository tempMemberRepository;

    // 무작위의 1회용 링크 생성
    public String generateInvitationLink() {
        UUID uuid = UUID.randomUUID();
        String randomLink = uuid.toString().replace("-", "");
        return baseUrl + randomLink;
    }


    // 링크 수락 후 로직
    public void acceptInvitationLink(Long id) {
        Member activateMember = tempMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
        activateMember.activate();
        tempMemberRepository.save(activateMember);

        // TODO 이미 활성화 되어있다면? -> 에러 메시지
    }

    //링크 만료 설정
    public void validateLink(Long linkId) {

    }


}

