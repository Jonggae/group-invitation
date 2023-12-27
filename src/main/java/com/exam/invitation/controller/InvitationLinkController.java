package com.exam.invitation.controller;

import com.exam.invitation.domain.TempMember;
import com.exam.invitation.dto.ApiResponseDto;
import com.exam.invitation.dto.TempMemberDto;
import com.exam.invitation.service.InvitationLinkService;
import com.exam.invitation.service.TempMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * 초대 링크관련된 컨트롤러*/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invitation")
public class InvitationLinkController {

    private final InvitationLinkService invitationLinkService;
    private final TempMemberService tempMemberService;

    //참여자 초대하기
    @PostMapping("/invite-member")
    // 그룹에 멤버를 초대하려면 무엇이 필요한가?
    // 링크 생성, 링크 전송 -> 이후 링크 수락하기
    public ResponseEntity<ApiResponseDto> inviteMember(@RequestBody TempMemberDto tempMemberDto) {
        TempMember tempMember = tempMemberService.createTempMember(tempMemberDto);
        String invitationLink = invitationLinkService.generateInvitationLink();
        return ResponseEntity.status(201).body(new ApiResponseDto("초대 링크 전송 완료", HttpStatus.CREATED.value()));

    }
    @PostMapping("/accept")
    // 링크를 수락하면 이루어지는 로직
    public ResponseEntity<ApiResponseDto> acceptInvitation(@RequestParam Long id) {
        invitationLinkService.acceptInvitationLink(id);

        return ResponseEntity.status(201).body(new ApiResponseDto("멤버가 초대요청을 수락하였습니다", HttpStatus.CREATED.value()));
    }


}
