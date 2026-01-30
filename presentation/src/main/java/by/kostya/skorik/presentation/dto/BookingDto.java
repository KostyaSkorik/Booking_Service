package by.kostya.skorik.presentation.dto;

import by.kostya.skorik.domain.model.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookingDto {
    private String userSub;
    private UUID coworkingId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private BigDecimal totalPrice;
}
