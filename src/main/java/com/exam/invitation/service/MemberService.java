package com.exam.invitation.service;

import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final InvitationLinkService invitationLinkService;

    // 초대 링크 생성과 함께 임시 멤버 생성해야함
    public void createMember(MemberDto memberDto) {
        invitationLinkService.generateInvitationLink();
        memberRepository.save(memberDto.toEntity());
    }


}
