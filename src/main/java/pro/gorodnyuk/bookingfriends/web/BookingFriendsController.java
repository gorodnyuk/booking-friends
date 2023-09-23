package pro.gorodnyuk.bookingfriends.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<InputStreamResource> downloadCertificate(@Valid BookingFriendsRequest request) {
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
