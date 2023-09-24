package pro.gorodnyuk.bookingfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

@Component
@RequiredArgsConstructor
public class PdfReportResponseGenerator {

    private final BookingFriendsService service;

    public ResponseEntity<InputStreamResource> generateResponse(BookingFriendsRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename("booking-certificate.pdf")
                .build());
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(service.reserve(request));
    }
}
