package pro.gorodnyuk.bookingfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pro.gorodnyuk.bookingfriends.dto.Certificate;
import pro.gorodnyuk.bookingfriends.entity.converter.BookingFriendConverter;
import pro.gorodnyuk.bookingfriends.repository.BookingFriendRepository;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

@Component
@RequiredArgsConstructor
public class PdfReportResponseGenerator {

    private final BookingFriendsService bookingFriendsService;
    private final BookingFriendRepository bookingFriendRepository;
    private final BookingFriendConverter bookingFriendConverter;

    public ResponseEntity<byte[]> generateResponse(BookingFriendsRequest request) {
        Certificate certificate = bookingFriendsService.reserve(request);
        bookingFriendRepository.save(bookingFriendConverter.convert(request));
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
