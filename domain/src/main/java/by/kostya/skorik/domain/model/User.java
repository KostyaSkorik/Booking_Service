package by.kostya.skorik.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String googleSub;
    private String name;
    private String email;
    private LocalDateTime lastLogin;
}