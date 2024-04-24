package edu.sejong.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sejong.ex.security.CustomNoOpPasswordEncoder;
import edu.sejong.ex.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

		// 해당 경로로 들어왔을 때, 무시하라는 의미이다. 막지 말라는 뜻.
		// 스프링 시큐리티에 적용되지 않도록
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**");
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return new CustomNoOpPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 테스트용 유저 만들기(인메모리 방식)
//		auth.inMemoryAuthentication()
//		.withUser("member").password("{noop}member").roles("USER")
//		.and()
//		.withUser("admin").password("{noop}admin").roles("ADMIN");

		auth.userDetailsService(customUserDetailsService)
			.passwordEncoder(passwordEncoder()); // 암호화 방식 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 우선 CSRF설정을 해제한다.
		// 초기 개발시만 해주는게 좋다.
		http.csrf().disable();

		// 권한 설정
		http.authorizeRequests()
			.antMatchers("/user/**").hasAnyRole("USER")
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/board/**").hasAnyRole("ADMIN")
  		 // .antMatchers("/company/list").hasAnyRole("ADMIN")
			.antMatchers("/**").permitAll();

		// 스프링 시큐리티가 기본적으로 가지고 있는 로그인 폼을 사용한다는 의미. 기본 설정이다.
		// http.formLogin();
		http.formLogin().loginPage("/login")
				// .loginPage("/elogin")
				.usernameParameter("id").passwordParameter("pw")
				// .defaultSuccessUrl("/board/list2")
				// .defaultSuccessUrl("/index")
				.defaultSuccessUrl("/").permitAll(); // 모든 사람에게 허용하겠다는 의미.
	}
}
