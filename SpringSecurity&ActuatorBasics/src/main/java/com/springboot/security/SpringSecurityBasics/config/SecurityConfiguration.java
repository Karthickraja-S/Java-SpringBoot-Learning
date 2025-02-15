package com.springboot.security.SpringSecurityBasics.config;

import com.springboot.security.SpringSecurityBasics.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // we can customise our own securityFilterChain here.
        return httpSecurity.csrf(x -> x.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/login","/hello").permitAll()
                        .requestMatchers("/actuator/**","/users").hasRole("ADMIN")
        //                .requestMatchers(HttpMethod.POST,"/users").hasRole("ADMIN") -> Can differentiate with HttpMethods too
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                // If session policy is STATELESS, then you have to hit all the API with username & password
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .build();
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));  // NoOpPasswordEncoder.getInstance() -> raw password is used and stored in DB
        return provider;
    }
//    @Bean
//    public UserDetailsService getUserDetails() {
//        return getInMemoryUserDetails();
//    }
//
//    private UserDetailsService getInMemoryUserDetails() {
//        UserDetails user1 = User.builder()
//                .username("karthick")
//                .password("{noop}1234")
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.builder()
//                .username("pushpaRaj")
//                .password("{noop}AlluArjun@123")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
}
