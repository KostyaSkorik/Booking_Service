package by.kostya.skorik.persistance.adapter;

import by.kostya.skorik.domain.kafka.BookingNotificationPort;
import by.kostya.skorik.domain.model.Booking;
import by.kostya.skorik.domain.model.BookingCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class BookingKafkaAdapter implements BookingNotificationPort {

    @Value("${kafka.topic}")
    private String topicName;

    private final KafkaTemplate<String,BookingCreatedEvent> kafkaTemplate;

    @Override
    public void sendBookingCreated(Booking booking) throws ExecutionException, InterruptedException {

        String messageKey = UUID.randomUUID().toString();

        BookingCreatedEvent bookingCreatedEvent = new BookingCreatedEvent(
                booking.getId(),
                booking.getUserSub(),
                booking.getCoworkingId(),
                booking.getStartTime(),
                booking.getEndTime(),
                booking.getTotalPrice()
        );

        ProducerRecord<String,BookingCreatedEvent> record = new ProducerRecord<>(
                topicName,
                messageKey,
                bookingCreatedEvent
        );


        SendResult<String,BookingCreatedEvent> result = kafkaTemplate.send(record).get();

        System.out.println(result.getRecordMetadata().topic());
        System.out.println(result.getRecordMetadata().partition());
        System.out.println(result.getRecordMetadata().offset());

    }
}
