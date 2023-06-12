package pro.gorodnyuk.bookingfriends.api;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.gorodnyuk.bookingfriends.service.BookingFriendsService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/booking-friends")
@RequiredArgsConstructor
public class BookingFriendsRestController {

    private final BookingFriendsService service;

    @PostMapping("/reserve")
    public ResponseEntity<InputStreamResource> reserve(@Valid @RequestBody BookingFriendsRequest request) {
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
