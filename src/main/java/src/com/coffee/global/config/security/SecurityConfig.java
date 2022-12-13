package src.com.coffee.global.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;
import src.com.coffee.domain.user.service.UserService;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
    // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //csrf 비활성화
        
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // 인증만 되면 들어갈 수 있는 주소
                .antMatchers("/**").permitAll();
//              .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
//              .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        
        http.formLogin()
                .usernameParameter("userId")
                .loginPage("/login")
//                .loginProcessingUrl("/login") // /login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해준다.
                .defaultSuccessUrl("/")
                .permitAll();
        
        http.logout()
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        		.logoutSuccessUrl("/login")
        		.invalidateHttpSession(true);
        
        http.exceptionHandling()
        		.accessDeniedPage("/denied");
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
