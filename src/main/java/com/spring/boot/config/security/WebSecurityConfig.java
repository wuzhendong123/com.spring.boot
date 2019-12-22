package com.spring.boot.config.security;


/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-11-29 11:34
 **/
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)// 控制权限注解
public class WebSecurityConfig //extends WebSecurityConfigurerAdapter
{
  //  @Override
   /* protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//授权处理
                .anyRequest().authenticated()
                .and()
                .formLogin() //登陆处理(from)
                .loginPage("/login")
                //设置默认登录成功跳转页面
                .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
                .and()
                //开启cookie保存用户数据
                .rememberMe() //RememberMeConfigurer
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                .key("")
                .and()
                .logout() //LogoutConfigurer
                //默认注销行为为logout，可以通过下面的方式来修改
                .logoutUrl("/custom-logout")
                //设置注销成功后跳转页面，默认是跳转到登录页面
                .logoutSuccessUrl("")
                .permitAll();
    }*/

}
