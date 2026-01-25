package by.kostya.skorik.presentation.dto;

import by.kostya.skorik.domain.model.Type;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CoworkingDto {
    private UUID id;
    private String name;
    private String description;
    private Integer capacity;
    private Type type;
    private String imageKey;
    private boolean isActive;
    private BigDecimal pricePerHour;
}
