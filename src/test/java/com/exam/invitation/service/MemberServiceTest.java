package com.exam.invitation.service;

import com.exam.invitation.domain.Member;
import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private InvitationLinkService invitationLinkService;
    @Mock
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("초대 링크를 보내기 위해 임시 회원 생성, 링크 생성 확인")
    @Transactional
    void inviteMember() {
        //given
        MemberDto memberDto = createMemberDto();

        when(invitationLinkService.generateInvitationLink()).thenReturn("");
        when(memberRepository.findByName(any())).thenReturn(Optional.empty());
        when(memberRepository.findByEmail(any())).thenReturn(Optional.empty());

        //when
        memberService.createMember(memberDto);

        // then
        verify(invitationLinkService, times(1)).generateInvitationLink();
        verify(memberRepository, times(1)).findByName(any());
        verify(memberRepository, times(1)).findByEmail(any());

        ArgumentCaptor<Member> memberCaptor = ArgumentCaptor.forClass(Member.class);
        verify(memberRepository, times(1)).save(memberCaptor.capture());

        Member savedMember = memberCaptor.getValue();
        System.out.println("Actual Email: " + savedMember.getEmail());  // 추가된 로깅 문
        System.out.println("Actual Phone Number: " + savedMember.getPhoneNumber());  // 추가된 로깅 문

        assertEquals("CJW", savedMember.getName());
        assertEquals("CJW@mail.com", savedMember.getEmail());
        assertEquals("01012345678", savedMember.getPhoneNumber());
    }

    private MemberDto createMemberDto() {
        return MemberDto.of(
                "CJW",
                "CJW@mail.com",
                "01012345678"
        );
    }
}