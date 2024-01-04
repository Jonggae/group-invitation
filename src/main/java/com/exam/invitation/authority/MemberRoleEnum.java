package com.exam.invitation.authority;

public enum MemberRoleEnum {
    TEMPMEMBER(Authority.TEMPMEMBER),
    MEMBER(Authority.MEMBER);

    private final String authority;

    MemberRoleEnum(String authority) {
        this.authority=authority;
    }
    public String getAuthority() {
        return this.authority;
    }

    public static class Authority{
        public static final String TEMPMEMBER = "ROLE_TEMPMEMBER";
        public static final String MEMBER = "ROLE_MEMBER";
    }
}
