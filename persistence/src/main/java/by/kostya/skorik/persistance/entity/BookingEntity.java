package by.kostya.skorik.persistance.entity;

import by.kostya.skorik.domain.model.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @NotNull
    private UUID id;

    //для разделения базы с пользователями
    @NotNull
    private UUID userId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "coworking_id")
    private CoworkingEntity coworking;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    @Version
    private Long version;
}
