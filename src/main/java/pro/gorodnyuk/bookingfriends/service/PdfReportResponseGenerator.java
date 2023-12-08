package pro.gorodnyuk.bookingfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pro.gorodnyuk.bookingfriends.dto.Certificate;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

@Component
@RequiredArgsConstructor
public class PdfReportResponseGenerator {

    private final BookingFriendsService bookingFriendsService;

    public ResponseEntity<byte[]> generateResponse(BookingFriendsRequest request) {
        Certificate certificate = bookingFriendsService.reserve(request);
        //todo add db
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(certificate.name())
                .build());
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(certificate.content());
    }
}
