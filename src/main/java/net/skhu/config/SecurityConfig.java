package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.skhu.service.MyAuthenticationProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired MyAuthenticationProvider myAuthenticationProvider;
    
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/res/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            .antMatchers("/guest/**").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/**").authenticated();

        http.csrf().disable();

        http.formLogin()
            .loginPage("/guest/login")
            .loginProcessingUrl("/guest/login_processing")
            .failureUrl("/guest/login?error")
            .defaultSuccessUrl("/user/index", true)
            .usernameParameter("loginId") //view에서 name값
            .passwordParameter("passwd");

        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing"))
            .logoutSuccessUrl("/guest/login")
            .invalidateHttpSession(true); //로그아웃할 때, 세션에 들어있는 데이터 전부 지우기

        http.authenticationProvider(myAuthenticationProvider);
    }

    
}
