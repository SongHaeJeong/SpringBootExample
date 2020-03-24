package com.rest.controller.dto.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rest.domain.member.Member;
import com.rest.domain.member.MemberRole;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberJoinRequestDto {

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotNull
    private MemberRole role;

    @Builder
    public MemberJoinRequestDto(String email, String password, String name, MemberRole role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .role(role)
                .build();
    }
}
