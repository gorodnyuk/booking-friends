package pro.gorodnyuk.bookingfriends.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.gorodnyuk.bookingfriends.service.PdfReportResponseGenerator;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/booking-friends")
@RequiredArgsConstructor
public class BookingFriendsRestController {

    private final PdfReportResponseGenerator pdfReportResponseGenerator;

    @PostMapping("/reserve")
    public ResponseEntity<byte[]> reserve(@Valid @RequestBody BookingFriendsRequest request) {
        return pdfReportResponseGenerator.generateResponse(request);
    }
}
