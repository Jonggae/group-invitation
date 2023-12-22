package com.exam.invitation;

import com.exam.invitation.domain.InvitationLink;
import com.exam.invitation.domain.TempMember;
import com.exam.invitation.repository.InvitationLinkRepository;
import com.exam.invitation.repository.TempMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InvitationApplicationTests {
    // 테스트 코드 작성 시, 선행되어야 할 조건들과 그 이유는 무엇일까? ↓↓
    // repository를 임포트, Autowired의 사용 이유

    private final TempMemberRepository memberRepository;
    private final InvitationLinkRepository invitationLinkRepository;

    @Autowired
    public InvitationApplicationTests(TempMemberRepository memberRepository, InvitationLinkRepository invitationLinkRepository) {
        this.memberRepository = memberRepository;
        this.invitationLinkRepository = invitationLinkRepository;
    }

    @Test
    void 임시회원생성() {
        // 회원 저장
        TempMember member = new TempMember();
        member.setName("CJW");
        member.setEmail("abc@mail.com");
        member.setPhoneNumber("0001234567");
        memberRepository.save(member);

        //임시 회원 검색
        TempMember findMember = memberRepository.findById(member.getId()).get(); // .get();을 왜 쓰는지?
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 초대링크생성() {

        InvitationLink link = new InvitationLink();
        link.setLink("asdfasdf");
        invitationLinkRepository.save(link);

        InvitationLink findLink = invitationLinkRepository.findById(link.getId()).get();
        Assertions.assertThat(link.getLink()).isEqualTo(findLink.getLink());

    }

}
