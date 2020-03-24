package com.rest.controller.dto.member;

import com.rest.domain.member.Member;
import com.rest.domain.member.MemberRole;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String email;
    private String name;
    private MemberRole role;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.role = member.getRole();
    }
}
