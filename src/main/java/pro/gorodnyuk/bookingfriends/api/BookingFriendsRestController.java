package pro.gorodnyuk.bookingfriends.api;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
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
        return ResponseEntity.ok(service.reserve(request));
    }
}
