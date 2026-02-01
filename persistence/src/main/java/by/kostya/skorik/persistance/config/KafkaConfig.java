package by.kostya.skorik.persistance.config;

import by.kostya.skorik.domain.model.BookingCreatedEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrap;

    @Value("${spring.kafka.producer.acks}")
    private String acks;

    @Value("${spring.kafka.producer.retries}")
    private String retries;

    @Value("${spring.kafka.producer.properties.delivery.timeout.ms}")
    private String deliveryTimeout;

    @Value("${spring.kafka.producer.properties.linger.ms}")
    private String linger;

    @Value("${spring.kafka.producer.properties.request.timeout.ms}")
    private String requestTimeout;

    @Value("${spring.kafka.producer.properties.enable.idempotence}")
    private String idempotence;

    @Value("${spring.kafka.producer.properties.max.in.flight.requests.per.connection}")
    private String maxInFlightRequest;

    @Value("${kafka.topic}")
    private String topicName;


    @Bean
    public KafkaTemplate<String, BookingCreatedEvent> bookingKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    ProducerFactory<String, BookingCreatedEvent> producerFactory() {
        Map<String, Object> factory = new HashMap<>();

        factory.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrap);
        factory.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        factory.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
        factory.put(ProducerConfig.ACKS_CONFIG, acks);
        factory.put(ProducerConfig.RETRIES_CONFIG, retries);
        factory.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, deliveryTimeout);
        factory.put(ProducerConfig.LINGER_MS_CONFIG, linger);
        factory.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeout);
        factory.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, idempotence);
        factory.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, maxInFlightRequest);

        return new DefaultKafkaProducerFactory<>(factory);

    }

    @Bean
    NewTopic newTopic() {
        return TopicBuilder
                .name(topicName)
                .partitions(3)
                .replicas(2)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }


}
