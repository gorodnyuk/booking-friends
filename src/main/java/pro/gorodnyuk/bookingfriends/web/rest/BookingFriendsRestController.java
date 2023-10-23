package pro.gorodnyuk.bookingfriends.web.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.gorodnyuk.bookingfriends.service.PdfReportResponseGenerator;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

import javax.validation.Valid;

@Tag(name = "Генерация сертификата", description = "Позволяет сгенерировать и получить сертификат на забронированного друга")
@RestController
@RequestMapping("/api/booking-friends")
@RequiredArgsConstructor
public class BookingFriendsRestController {

    private final PdfReportResponseGenerator pdfReportResponseGenerator;

    @Operation(
            summary = "Сгенерировать и получить сертификат",
            description = "Позволяет сгенерировать и получить сертификат на забронированного друга")
    @PostMapping("/reserve")
    public ResponseEntity<byte[]> reserve(@Valid @RequestBody BookingFriendsRequest request) {
        return pdfReportResponseGenerator.generateResponse(request);
    }
}
