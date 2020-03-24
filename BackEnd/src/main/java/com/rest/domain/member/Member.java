package com.rest.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email" , nullable = false) // 컬럼의 이름을 설정하고 NotNull 설정
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "name" , nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING) // User, Admin 나눔
	private MemberRole role;
	
	@Builder
	public Member(String email, String password, String name, MemberRole role) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	
	// 패스워드를 암호화하는 메서드 
	public void encodingPassword(String password) {
		this.password = password;
	}
	
}
