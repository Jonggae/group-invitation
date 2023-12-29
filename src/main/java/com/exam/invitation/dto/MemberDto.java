package com.exam.invitation.dto;

import com.exam.invitation.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String name;
    private String email;
    private String phoneNumber;

    public Member toTempMember() {
        Member tempMember = new Member();
        tempMember.setName(this.name);
        tempMember.setEmail(this.email);
        tempMember.setPhoneNumber(this.phoneNumber);
        // activate 는 초기값이 false 이므로 생략
        return tempMember;
    }
}
