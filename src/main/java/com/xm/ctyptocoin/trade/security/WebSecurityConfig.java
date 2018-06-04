package com.xm.ctyptocoin.trade.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by xxz on 2018/5/19.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//使用@EnableGlobalMethodSecurity(prePostEnabled = true)
// 这个注解，可以开启security的注解，我们可以在需要控制权限的方法上面使用@PreAuthorize，@PreFilter这些注解。
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
//    CustomSuccessHandler customSuccessHandler;

    @Override
    @Bean
    public UserDetailsService userDetailsService() { //覆盖写userDetailsService方法 (1)
        return new SpringUserDetailsService();
    }


//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
//    }

    /**
     * If subclassed this will potentially override subclass configure(HttpSecurity)
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/amchart/**",
                        "/bootstrap/**",
                        "/build/**",
                        "/css/**",
                        "/dist/**",
                        "/documentation/**",
                        "/fonts/**",
                        "/js/**",
                        "/pages/**",
                        "/plugins/**",
                        "/vendors/**"
                ).permitAll() //默认不拦截静态资源的url pattern （2）
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login")// 登录url请求路径 (3)
//                .successHandler(customSuccessHandler)
                .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll().and() // 登录成功跳转路径url(4)
                .logout().permitAll()
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied")
                ;

        http.logout().logoutSuccessUrl("/"); // 退出默认跳转页面 (5)

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth
        //    .inMemoryAuthentication()
        //    .withUser("root")
        //    .password("root")
        //    .roles("ADMIN", "USER")
        //    .and()
        //    .withUser("admin").password("admin")
        //    .roles("ADMIN", "USER")
        //    .and()
        //    .withUser("user").password("user")
        //    .roles("USER");


        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());; // （6）
    }

}
