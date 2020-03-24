package com.rest.apprunner;





import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rest.controller.dto.member.MemberJoinRequestDto;
import com.rest.domain.member.MemberRole;
import com.rest.domain.member.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component

public class AppRunner  {

	
//    private final MemberService memberService;
//    
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//    	MemberJoinRequestDto dto = MemberJoinRequestDto.builder()
//    			.email("cjsong@naver.com")
//    			.password("1234")
//    			.role(MemberRole.USER)
//    			.name("정송해")
//    			.build();
//    	memberService.save(dto);    			
//       
//    }
}
