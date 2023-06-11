package pro.gorodnyuk.bookingfriends.api;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/booking-friends")
public class BookingFriendsRestController {

    @PostMapping("/reserve")
    public ResponseEntity<InputStreamResource> reserve(@Valid @RequestBody BookingFriendsRequest request) {
        return ResponseEntity.ok().build();
    }
}
