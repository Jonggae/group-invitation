package com.exam.invitation.domain;

import com.exam.invitation.repository.InvitationLinkRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 초대 링크
@Entity
@Getter
@NoArgsConstructor
public class InvitationLink {

    @Id
    @GeneratedValue
    private long id;
    private String Link;

    public InvitationLink(String link) {
        Link = link;
    }

    public static InvitationLink of(String link){
        return new InvitationLink(link);
    }
}
