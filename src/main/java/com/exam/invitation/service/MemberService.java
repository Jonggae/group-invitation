package com.exam.invitation.service;

import com.exam.invitation.domain.Member;
import com.exam.invitation.dto.MemberDto;
import com.exam.invitation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository tempMemberRepository;

    // 초대 링크 생성과 함께 임시 멤버 생성해야함
    public Member createTempMember(MemberDto tempMemberDto) {
        Member tempMember = tempMemberDto.toTempMember();

        if (tempMemberRepository.findByName(tempMember.getName()).isPresent()
                || tempMemberRepository.findByEmail(tempMember.getEmail()).isPresent()) {
            throw new IllegalArgumentException("같은 이름, 이메일이 존재합니다");
        }
        tempMemberRepository.save(tempMember);
        // 임시 멤버 생성 완료
        return tempMember;
    }


}
