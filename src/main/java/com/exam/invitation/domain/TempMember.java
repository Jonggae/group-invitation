package com.exam.invitation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TempMember {
    @Id
    @GeneratedValue
    private long id;

    private String name; //초대받을 사용자 이름
    private String phoneNumber; //초대받을 사용자의 전화번호
    private String email; //초대받을 사용자의 이메일 주소

    private boolean activated = Boolean.FALSE; //임시 회원이므로 활성화 태그를 만들어 활성화 시키지 않음.

    // 임시 회원을 생성하려면 getter setter가 필요한가?
}
