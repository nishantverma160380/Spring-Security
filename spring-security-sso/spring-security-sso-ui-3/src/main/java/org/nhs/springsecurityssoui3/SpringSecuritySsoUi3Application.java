package org.nhs.springsecurityssoui3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.context.request.RequestContextListener;

@EnableOAuth2Sso
@SpringBootApplication
public class SpringSecuritySsoUi3Application extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .logout()
            .logoutUrl("/j_spring_security_logout")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("UI3SESSION")
            .logoutSuccessUrl("/");
        
        http.csrf().disable();
    }
	
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySsoUi3Application.class, args);
	}
}
