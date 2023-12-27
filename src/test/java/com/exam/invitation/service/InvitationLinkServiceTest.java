package com.exam.invitation.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class InvitationLinkServiceTest {

    @Autowired
    private InvitationLinkService invitationLinkService;

    @Test
    @DisplayName("회원 초대 링크가 제대로 생성되는지 확인")
    void generateInvitationLink() {
        //given

        //when
        String generatedLink1 = invitationLinkService.generateInvitationLink();
        String generatedLink2 = invitationLinkService.generateInvitationLink();

        //then
        assertNotNull(generatedLink1);
        assertNotNull(generatedLink2);
        System.out.println(generatedLink1);
        System.out.println(generatedLink2);
        assertNotEquals(generatedLink1, generatedLink2);

    }
}