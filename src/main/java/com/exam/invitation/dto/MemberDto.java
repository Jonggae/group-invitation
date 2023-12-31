package com.exam.invitation.dto;

import com.exam.invitation.domain.Member;


public record MemberDto(String name, String email, String phoneNumber) {

    public static MemberDto of(String name, String email, String phoneNumber) {
        return new MemberDto(name, email, phoneNumber);
    }

    public static MemberDto from(Member entity) {
        return new MemberDto(
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber());
    }

    public Member toEntity() {
        return Member.of(name, email, phoneNumber);
    }

}
