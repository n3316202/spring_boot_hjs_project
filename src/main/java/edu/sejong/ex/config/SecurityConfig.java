package edu.sejong.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sejong.ex.security.CustomNoOpPasswordEncoder;
import edu.sejong.ex.security.CustomUserDetailsService;
import edu.sejong.ex.security.EmpUserDetailsService;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private CustomUserDetailsService customUserDetailsService;
	
	 @Autowired
	 private EmpUserDetailsService empUserDetailsService;
		
	 
/*	이미지(가영이)가 보이지 않는다.
	우선 정적파일들은 시큐리티에 적용되지 않도록 아래와 같이 설정을 한다.
	이제 더이상 리소스파일들은 스프링 시큐리티에서 관리를 하지 않는다.	*/
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//우선 CSRF설정을 해제한다.
		//초기 개발시만 해주는게 좋다.
		http.csrf().disable();
		
		/*권한 설정*/
		http.authorizeRequests()
		.antMatchers("/user/**").hasAnyRole("USER") 
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/**").permitAll();
		
		http.formLogin()
		        .loginPage("/login") //loginPage() 는 말그대로 로그인할 페이지 url 이고
		        .usernameParameter("id")
		        .passwordParameter("pw")
		        .defaultSuccessUrl("/")
		        .permitAll(); //모든 유저가 로그인 화면은 볼 수 있게 한다
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
		return new CustomNoOpPasswordEncoder();
    }
	
	//테스트용 유저 만들기(인메모리 방식)
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth .inMemoryAuthentication()
		 * .withUser("member").password("{noop}member").roles("USER") .and()
		 * .withUser("admin").password("{noop}admin").roles("ADMIN");
		 */
		auth.userDetailsService(empUserDetailsService)
				.passwordEncoder(passwordEncoder());
		
	}

}
