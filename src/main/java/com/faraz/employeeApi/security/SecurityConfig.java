package com.faraz.employeeApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    //add support for jdb
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"api/v2/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"api/v2/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT,"api/v2/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"api/v2/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"api/v2/employees/**").hasRole("ADMIN")
                );
        //use http basic auth
        httpSecurity.httpBasic(Customizer.withDefaults());

        //disable csrf
        httpSecurity.csrf(csrf->csrf.disable());

        return httpSecurity.build();
    }

    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john = User.builder().username("john").password("{noop}test123")
//                .roles("EMPLOYEE").build();
//        UserDetails marry = User.builder().username("marry").password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER").build();
//        UserDetails faraz = User.builder().username("faraz").password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER","ADMIN").build();
//
//        return new InMemoryUserDetailsManager(john,marry,faraz);
//
//    }
}
