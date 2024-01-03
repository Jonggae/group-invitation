package com.exam.invitation.domain;

import com.exam.invitation.authority.MemberRoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private long id;

    private String name; //초대받을 사용자 이름
    private String phoneNumber; //초대받을 사용자의 전화번호
    private String email; //초대받을 사용자의 이메일 주소

    @Enumerated(EnumType.STRING)
    private MemberRoleEnum role = MemberRoleEnum.TEMPMEMBER; // 멤버 권한 분리

    private boolean isActivated = Boolean.FALSE; //임시 회원이므로 활성화 태그를 만들어놓고 활성화 시키지 않음.

    private Member(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public static Member of(String name, String phoneNumber, String email) {
        return new Member(name, phoneNumber, email);
    }

    public void activate() {
        this.setIsActivated();
    }

    private void setIsActivated() {
        this.isActivated = true;
        this.role = MemberRoleEnum.MEMBER;
    }

}
