package com.exam.invitation.dto;

import com.exam.invitation.domain.InvitationLink;

public class InvitationLinkDto {
    private String link;

    public InvitationLinkDto(String link) {}

    public InvitationLinkDto of(String link) {
        return new InvitationLinkDto(link);
    }

    public static InvitationLinkDto from(InvitationLink entity) {
        return new InvitationLinkDto(entity.getLink());
    }

    public InvitationLink toEntity() {
        return InvitationLink.of(link);
    }
}
