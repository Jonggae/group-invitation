package com.exam.invitation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/*
* 사용자를 초대할 그룹
* 특정한 그룹만 있으면 된다*/
@Entity
public class InvitationGroup {

    @Id
    @GeneratedValue
    private long id;
    private String groupName; //그룹 이름 끝
}
