package by.kostya.skorik.presentation.oauthservice;

import by.kostya.skorik.domain.model.User;
import by.kostya.skorik.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Primary
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserService userService;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String googleSub = oAuth2User.getAttribute("sub");
        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");


        LocalDateTime lastLogin = LocalDateTime.now();
        User user = new User();

        user.setGoogleSub(googleSub);
        user.setName(name);
        user.setEmail(email);
        user.setLastLogin(lastLogin);

        userService.saveUser(user);
        return oAuth2User;
    }
}
