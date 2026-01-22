package by.kostya.skorik.persistance.entity;

import by.kostya.skorik.domain.model.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "coworkings")
public class CoworkingEntity {
    @Id
    private UUID id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;

    private String imageKey;

    @ColumnDefault(value = "true")
    @NotNull
    private boolean isActive;

    @NotNull
    private BigDecimal pricePerHour;

    @Version
    @ColumnDefault(value = "0")
    @NotNull
    private Long version;
}
