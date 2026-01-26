package by.kostya.skorik.presentation.controller.in;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface UserController {

    @GetMapping("/user/me")
    Map<String, String> getCurrentUser(@AuthenticationPrincipal OAuth2User oAuth2User);
}
