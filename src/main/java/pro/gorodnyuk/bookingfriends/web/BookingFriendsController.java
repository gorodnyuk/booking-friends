package pro.gorodnyuk.bookingfriends.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pro.gorodnyuk.bookingfriends.service.PdfReportResponseGenerator;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BookingFriendsController {

    private final PdfReportResponseGenerator pdfReportResponseGenerator;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("request", new BookingFriendsRequest());
        return "index";
    }

    @PostMapping("/")
    public ResponseEntity<byte[]> downloadCertificate(@Valid BookingFriendsRequest request) {
        return pdfReportResponseGenerator.generateResponse(request);
    }
}
