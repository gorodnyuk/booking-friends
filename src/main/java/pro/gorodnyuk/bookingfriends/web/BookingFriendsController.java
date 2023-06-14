package pro.gorodnyuk.bookingfriends.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingFriendsController {

    @PostMapping("/reserve")
    public String downloadCertificate() {
        throw new RuntimeException("Not implemented yet");
    }
}
