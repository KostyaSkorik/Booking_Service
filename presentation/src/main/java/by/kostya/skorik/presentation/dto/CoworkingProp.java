package by.kostya.skorik.presentation.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class CoworkingProp {
    @Value(value = "${minio.ip}")
    private String imageUrl;
    @Value(value = "${minio.bucket.coworking}")
    private String bucket;
}
