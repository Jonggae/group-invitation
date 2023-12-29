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
        checkNameAndEmail(memberDto);
        memberRepository.save(memberDto.toEntity());
    }

    private void checkNameAndEmail(MemberDto memberDto) {
        if (memberRepository.findByName(memberDto.toEntity().getName()).isPresent()) {
            throw new IllegalArgumentException("같은 이름이 이미 존재합니다");
        }
        if (memberRepository.findByEmail(memberDto.toEntity().getEmail()).isPresent()) {
            throw new IllegalArgumentException("같은 이메일이 이미 존재합니다");
        }
    }}
