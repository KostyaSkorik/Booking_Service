package by.kostya.skorik.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Coworking {
    private UUID id;
    private String name;
    private String description;
    private Integer capacity;
    private Type type;
    private String imageKey;
    private boolean isActive;
    private BigDecimal pricePerHour;
    private Long version;
}