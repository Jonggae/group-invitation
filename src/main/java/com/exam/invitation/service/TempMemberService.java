package com.exam.invitation.service;

import com.exam.invitation.domain.TempMember;
import com.exam.invitation.repository.TempMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempMemberService {

    private final TempMemberRepository tempMemberRepository;

    // 초대 링크 생성과 함께 임시 멤버 생성
    public void createTempMember(String name, String email, String phoneNumber) {
        TempMember tempMember = new TempMember();
        tempMember.setName(name);
        tempMember.setEmail(email);
        tempMember.setPhoneNumber(phoneNumber);
        // activate는 초기값이 false이므로 생략

        tempMemberRepository.save(tempMember);
    }


}
