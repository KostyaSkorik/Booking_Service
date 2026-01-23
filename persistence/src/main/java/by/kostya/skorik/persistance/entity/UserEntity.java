package by.kostya.skorik.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private UUID id;

    @NotNull
    private String googleSub;

    @NotNull
    private String name;

    @NotNull
    private String email;

    private LocalDateTime lastLogin;
}