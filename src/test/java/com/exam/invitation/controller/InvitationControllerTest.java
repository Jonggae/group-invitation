package com.exam.invitation.controller;

import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.service.InvitationLinkService;
import com.exam.invitation.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
class InvitationControllerTest {

    @InjectMocks
    private InvitationController invitationController;
    @Mock
    private InvitationLinkService invitationLinkService;
    @Mock
    private MemberService memberService;

    @Test
    @DisplayName("컨트롤러가 올바른 응답을 하는지 테스트")
    void inviteMemberAndCreateMemberAndReturnResponseEntity() {
        //given
        MemberDto memberDto = createMemberDto();
        //when
        ResponseEntity<String> response = invitationController.inviteMember(memberDto);

        //then
        verify(memberService, times(1)).createMember(memberDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("초대 링크를 보냈습니다.", response.getBody());
    }

    @Test
    @DisplayName("수락하였을때의 경우")
    void acceptInvitation_shouldCallAcceptInvitationLinkAndReturnResponseEntity() {
        //given
        Long invitationId = 1L;

        //when
        ResponseEntity<String> response = invitationController.acceptInvitation(invitationId);

        //then
        verify(invitationLinkService, times(1)).acceptInvitationLink(invitationId);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("멤버가 초대 요청을 수락하였습니다", response.getBody());
    }

    private MemberDto createMemberDto() {
        return MemberDto.of(
                "CJW",
                "CJW@mail.com",
                "01012345678"
        );
    }

}

