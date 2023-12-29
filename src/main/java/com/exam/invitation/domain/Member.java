package com.exam.invitation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

//    private final boolean activated = Boolean.FALSE; //임시 회원이므로 활성화 태그를 만들어놓고 활성화 시키지 않음.

    private Member(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public static Member of(String name, String phoneNumber, String email) {
        return new Member(name, phoneNumber, email);
    }

//    public void activate() {
//        this.setActivated(true);
//    }
//
//    private void setActivated(boolean b) {
//    }

}
