package com.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rest.domain.member.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // WebSecurityConfigurerAdapter를 통해 Spring Security의 설정을 커스텀
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder);
    }

    // 회원가입을 하는 URL을 제외한 모든 접속은 인증을 필요로 하게 설
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    	http
    		.authorizeRequests()
    		.antMatchers(HttpMethod.POST, "/api/members/join").permitAll()
    		.anyRequest().authenticated();
    }
}
