package com.exam.invitation.controller;

import com.exam.invitation.domain.Member;
import com.exam.invitation.dto.ApiResponseDto;
import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class InvitationControllerTest {


    // controller에는 mock을 사용?
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MemberRepository tempMemberRepository;

    @Test
    @DisplayName("링크 생성 후 전송 테스트")
    void inviteMember() throws Exception {
        //given
        MemberDto tempMemberDto = new MemberDto();
        tempMemberDto.setName("CJW");
        tempMemberDto.setEmail("CJW@mail.com");
        tempMemberDto.setPhoneNumber("1012345678");

        //when -> 여기에 작성되는 내용에 대한 이해 필요
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/invitation/invite-member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tempMemberDto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        //then
        String responseContent = mvcResult.getResponse().getContentAsString();
        ApiResponseDto apiResponseDto = objectMapper.readValue(responseContent, ApiResponseDto.class);
        assertThat(apiResponseDto.getMsg()).isEqualTo("초대 링크 전송 완료");

        Optional<Member> savedTempMember = tempMemberRepository.findByName("CJW");
        assertThat(savedTempMember).isPresent();
    }

    @Test
    @DisplayName("초대 수락 테스트")
    void acceptInvitation() throws Exception {
        //given
        Long invitationId = 1L;

        Member tempMember = new Member();
        tempMemberRepository.save(tempMember);

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
}

