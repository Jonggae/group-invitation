package com.exam.invitation.service;

import com.exam.invitation.domain.TempMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TempMemberServiceTest {

    private TempMemberService tempMemberService;

    @Test
    @DisplayName("임시 회원 생성되는지 확인")
    void createTempMember() {
        // given
        TempMember tempMember = new TempMember();

        // when
        tempMember.setName("CJW");
        tempMember.setEmail("CJW@mail.com");
        tempMember.setPhoneNumber("01012345678");

        // then
        assertThat(tempMember)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name","CJW")
                .hasFieldOrPropertyWithValue("email","CJW@mail.com")
                .hasFieldOrPropertyWithValue("phoneNumber","01012345678");

    }
}