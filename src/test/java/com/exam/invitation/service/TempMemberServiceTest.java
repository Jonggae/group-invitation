package com.exam.invitation.service;

import com.exam.invitation.domain.TempMember;
import com.exam.invitation.dto.TempMemberDto;
import com.exam.invitation.repository.TempMemberRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TempMemberServiceTest {

    @Autowired
    private TempMemberService tempMemberService;

    // autowired가 없으면 오류가 발생
    // Cannot invoke "com.exam.invitation.service.TempMemberService.createTempMember(String, String, String)" because "this.tempMemberService" is null
    @Autowired private TempMemberRepository tempMemberRepository;

    @Test
    @Disabled
    @DisplayName("임시 회원 생성되는지 확인 -> 목적이 다른 테스트 코드로 비활성화함")
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
        // 이상의 테스트는 메서드를 테스트하는 것이 아니라 다시 작성하기로 함
    }

    @Test
    @DisplayName("임시 회원 생성되는지 확인")
    @Transactional
    void createTempMember2() {
        //given
        TempMemberDto tempMemberDto = new TempMemberDto();
        String name = "CJW";
        String email = "CJW@mail.com";
        String phoneNumber = "01012345678";

        //when
        tempMemberService.createTempMember(tempMemberDto);

        // then
        Optional<TempMember> savedTempMember = tempMemberRepository.findByName(tempMemberDto.getName());

        assertThat(savedTempMember).isNotNull();
        assertThat(savedTempMember.get().getName()).isEqualTo(tempMemberDto.getName());
        assertThat(savedTempMember.get().getEmail()).isEqualTo(tempMemberDto.getEmail());
        assertThat(savedTempMember.get().getPhoneNumber()).isEqualTo(tempMemberDto.getPhoneNumber());
        assertThat(savedTempMember.get().isActivated()).isFalse();
    }
}