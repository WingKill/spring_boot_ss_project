package edu.sejong.ex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

		// 해당 경로로 들어왔을 때, 무시하라는 의미이다. 막지 말라는 뜻.
		// 스프링 시큐리티에 적용되지 않도록
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**");
	}

	// 테스트용 유저 만들기(인메모리 방식)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("member").password("{noop}member").roles("USER")
		.and()
		.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
}
