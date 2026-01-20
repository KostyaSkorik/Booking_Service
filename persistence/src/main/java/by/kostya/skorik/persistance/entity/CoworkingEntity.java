package by.kostya.skorik.persistance.entity;

import by.kostya.skorik.domain.model.Type;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "coworkings")
public class CoworkingEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String imageKey;
    private boolean isActive;
    private BigDecimal pricePerHour;
    @Version
    private Long version;
}
