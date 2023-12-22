package com.exam.invitation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// 초대 링크
@Entity
@Getter
@Setter
public class InvitationLink {

    @Id
    @GeneratedValue
    private long id;

    private String Link;
}
