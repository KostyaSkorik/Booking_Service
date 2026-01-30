package by.kostya.skorik.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Data
public class Booking {
    private UUID id;
    private String userSub;
    private UUID coworkingId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private BigDecimal totalPrice;
    private Long version;


    private void calculateTotal(BigDecimal pricePerHouse) {
        this.totalPrice = new BigDecimal(ChronoUnit.HOURS.between(startTime,endTime));
        totalPrice = totalPrice.multiply(pricePerHouse);
    }
}
