package com.exam.invitation.controller;

import com.exam.invitation.dto.InvitationLinkDto;
import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.service.InvitationLinkService;
import com.exam.invitation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * 초대 링크관련된 컨트롤러*/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invitation")
public class InvitationController {

    private final InvitationLinkService invitationLinkService;
    private final MemberService memberService;

    /*
    * 초대 작업 수행 시 링크 생성, 임시 멤버 생성이 진행됨*/
    @PostMapping("/invite-member")
    public ResponseEntity<String> inviteMember(@RequestBody MemberDto memberDto) {
        memberService.createMember(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("초대 링크를 보냈습니다.");
    }

//    @GetMapping("/generate-link")
//    public InvitationLinkDto generateInvitationLink() {
//        String generatedLink = invitationLinkService.generateInvitationLink();
//        return InvitationLinkDto.of(generatedLink);
//    }

    @PostMapping("/accept")
    public ResponseEntity<String> acceptInvitation(@RequestParam Long id) {
        invitationLinkService.acceptInvitationLink(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("멤버가 초대 요청을 수락하였습니다");
    }


}
