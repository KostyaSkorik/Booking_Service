package by.kostya.skorik.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Booking {
    private UUID id;
    private UUID userId;
    private UUID coworkingId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private BigDecimal totalPrice;
    private Long version;


    private void calculateTotal() {
        this.totalPrice = new BigDecimal(100);
    }
}
