package by.kostya.skorik.presentation.controller.impl;

import by.kostya.skorik.presentation.controller.in.UserController;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UserControllerImpl implements UserController {

    @Override
    public Map<String, String> getCurrentUser(OAuth2User oAuth2User) {
        if (oAuth2User == null) {
            return null;
        }
        return Map.of(
                "name", Objects.requireNonNull(oAuth2User.getAttribute("name")),
                "email", Objects.requireNonNull(oAuth2User.getAttribute("email")),
                "picture", Objects.requireNonNull(oAuth2User.getAttribute("picture")));
    }
}
