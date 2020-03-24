package com.rest.domain.member;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.controller.dto.member.MemberJoinRequestDto;
import com.rest.controller.dto.member.MemberResponseDto;

import lombok.RequiredArgsConstructor;

/*
 * Spring Data Jpa를 이용하여 MemberRepository를 생성, 차후에 토큰 발급 및 로그인을 위해 email로 찾는 로직을 추가
 * Service단에서는 Member는 저장하는 로직과 member를 조회하는 로직 생성 
 * 03.24
 */

@RequiredArgsConstructor // 초기화 되지 않은 final 필드와 @NonNull 어노테이션이 부튼 필드에 대한 생성자 생성 
@Service
@Transactional(readOnly = true) //트랜잭션 선언
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Transactional
	public Long Save(MemberJoinRequestDto dto) {
		return memberRepository.save(dto.toEntity()).getId();
	}
	
    public MemberResponseDto findOne(Long id) {
        Member member = memberRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return new MemberResponseDto(member);
    }
    
    public MemberResponseDto findByEmail(String email) {
        Member findMember = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return new MemberResponseDto(findMember);
    }


}
