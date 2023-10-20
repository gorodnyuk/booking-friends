package pro.gorodnyuk.bookingfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.gorodnyuk.bookingfriends.dto.Certificate;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

@Service
@RequiredArgsConstructor
public class BookingFriendsService {

    private final CertificateReceiver certificateReceiver;

    public Certificate reserve(BookingFriendsRequest request) {
        return certificateReceiver.reserve(request);
    }
}
