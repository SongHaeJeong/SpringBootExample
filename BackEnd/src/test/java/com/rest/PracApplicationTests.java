package com.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.rest.controller.dto.member.MemberJoinRequestDto;
import com.rest.domain.member.MemberRole;
import com.rest.domain.member.MemberService;

@SpringBootTest
@AutoConfigureMockMvc
class PracApplicationTests {

	@Autowired
	MemberService memberService;

	@Autowired
	MockMvc mockMvc;

	@Value("${custom.clientId}")
	private String clientId;
	@Value("${custom.clientSecret}")
	private String clientSecret;

	
	
	
	@Test
	void contextLoads() {
	}

	@Test
	void getJwtToken() throws Exception {
		String password = "qwe112323123";
		String email = "email12123@gmail.com";
		MemberJoinRequestDto joinDto = MemberJoinRequestDto.builder().email(email).password(password).name("John")
				.role(MemberRole.USER).build();
		memberService.save(joinDto);

		// when & then
			
//		this.mockMvc.perform(post("/oauth/token")
//				.with(HttpBasic(clientId, clientSecret))
//				.param("username",email)
//				.param("password", password)
//				.param("grant_tpye", "password")
//				).andDo(print());
//		
		
		
	}

}
