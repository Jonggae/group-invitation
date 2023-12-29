package com.exam.invitation.service;

import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class TempMemberServiceTest {
    private final MockMvc mvc;

    public TempMemberServiceTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("임시 회원 생성되는지 확인")
    @Transactional
    void createTempMember() {
        //given

        //when

        // then


    }

    private MemberDto createMemberDto() {
        return MemberDto.of(
                "CJW",
                "CJW@mail.com",
                "01012345678"
        );
    }
}