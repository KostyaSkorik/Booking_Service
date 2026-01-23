package by.kostya.skorik.presentation.config;

import by.kostya.skorik.presentation.oauthservice.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class OAuthConfiguration {


    private final CustomOAuth2UserService customOAuth2UserService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(httpReq -> {
                    httpReq.anyRequest().authenticated();
                })

                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/coworking/api/all",true)
                        .userInfoEndpoint(userInfo->userInfo.userService(customOAuth2UserService)))
                .build();
    }
}
