package pro.gorodnyuk.bookingfriends.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pro.gorodnyuk.bookingfriends.dto.Certificate;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

@Component
public class CertificateReceiverImpl implements CertificateReceiver {

    private final String uri;
    private final RestTemplate restTemplate;

    public CertificateReceiverImpl(@Value("${external.certificate-generator.uri}") String certificateGeneratorUri) {
        this.uri = certificateGeneratorUri + "/api/v1/certificate/generate";
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Certificate reserve(BookingFriendsRequest request) {
        ResponseEntity<byte[]> certificateResponseEntity = restTemplate.postForEntity(uri, request, byte[].class);
        return new Certificate(certificateResponseEntity.getHeaders().getContentDisposition().getFilename(), certificateResponseEntity.getBody());
    }
}
