package com.exam.invitation.controller;

import com.exam.invitation.domain.Member;
import com.exam.invitation.dto.InvitationLinkDto;
import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.repository.MemberRepository;
import com.exam.invitation.service.InvitationLinkService;
import com.exam.invitation.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(InvitationController.class)
class InvitationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepository;

    @MockBean
    private MemberService memberService;
    @MockBean
    private InvitationLinkService invitationLinkService;


    @Test
    @DisplayName("링크 생성 테스트")
    void generateLink() throws Exception {
        //given
        String baseUrl = "http://testdomain.com";
        String generatedLink = baseUrl + "mocked-link";

        when(invitationLinkService.generateInvitationLink()).thenReturn(generatedLink);

        //when &then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/invitation/generate-link")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.link").value(generatedLink));
    }

    @Test
    @DisplayName("링크 생성 후 전송 테스트 - inviteMember")
    void inviteMember() throws Exception {
        //given


        //when


        //then

    }

    @Test
    @DisplayName("초대 수락 테스트")
    void acceptInvitation() throws Exception {
        //given
        Long invitationId = 1L;

        Member Member = new Member();
        memberRepository.save(Member);

        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/invitation/accept")
                        .param("id", String.valueOf(invitationId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.msg").value("멤버가 초대요청을 수락하였습니다"))
                .andExpect(jsonPath("$.statusCode").value(201))
                .andReturn();

        //then
    }

    private MemberDto createMemberDto() {
        return MemberDto.of(
                "CJW",
                "CJW@mail.com",
                "01012345678"
        );
    }

    private InvitationLinkDto createInvitationLinkDto() {
        return InvitationLinkDto.of(
                "asdf");

    }


}

