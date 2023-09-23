package pro.gorodnyuk.bookingfriends.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pro.gorodnyuk.bookingfriends.service.BookingFriendsService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BookingFriendsController {

    private final BookingFriendsService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("request", new BookingFriendsRequest());
        return "index";
    }

    @PostMapping("/")
    public String downloadCertificate(@Valid BookingFriendsRequest request) {
        service.reserve(request);
        return "redirect:/";
    }
}
