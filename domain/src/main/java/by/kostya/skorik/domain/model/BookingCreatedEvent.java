package by.kostya.skorik.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingCreatedEvent {
    private UUID bookingId;
    private String userSub;
    private UUID coworkingId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal price;
}
