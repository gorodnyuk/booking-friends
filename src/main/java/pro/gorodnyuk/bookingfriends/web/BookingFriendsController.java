package pro.gorodnyuk.bookingfriends.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pro.gorodnyuk.bookingfriends.service.BookingFriendsService;

@Controller
@RequiredArgsConstructor
public class BookingFriendsController {

    private final BookingFriendsService service;

    @GetMapping("/")
    public String index() {
        throw new RuntimeException("Not implemented yet");
    }

    @PostMapping("/")
    public String downloadCertificate() {
        throw new RuntimeException("Not implemented yet");
    }
}
