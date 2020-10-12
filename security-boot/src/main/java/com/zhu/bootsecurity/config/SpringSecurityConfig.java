package com.zhu.bootsecurity.config;

import com.zhu.bootsecurity.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zpm
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证用户的来源 内存或者数据库
     *
     * @param auth auth
     * @throws Exception e
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用数据库中的对象
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//                inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}123")
//                //这里不用加ROLE_   SpringBoot会自动的给我们加上
//                .roles("USER");
    }

    /**
     * 配置security相关的信息
     *
     * @param http http
     * @throws Exception e
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //那些资源不拦截必须放在最前面
                .antMatchers("/login.jsp", "/failer.jsp", "/img/**", "/css/**", "/plugins/**").permitAll()
                //其他的任何资源都需要认证之后才能访问
                .antMatchers("/**").hasAnyRole("USER", "ADMIN").anyRequest().authenticated()
                .and()

                //指定表单登录
                .formLogin()
                //登录页面
                .loginPage("/login.jsp")
                //登录用的处理器,这里需要用security提供的
                .loginProcessingUrl("/login")
                //登录成功去哪里
                .successForwardUrl("/index.jsp")
                //登录失败去哪里
                .failureForwardUrl("/failer.jsp")
                //允许这几个路径可以访问
                .permitAll()

                //指定退出
                .and()
                .logout()
                //登出的处理器地址
                .logoutUrl("/logout")
                //登出成功的页面
                .logoutSuccessUrl("/login.jsp")
                //清除session
                .invalidateHttpSession(true)
                .permitAll()

                //暂时将它关了
                .and()
                .csrf()
                .disable();
    }
}
