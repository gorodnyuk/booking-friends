package pro.gorodnyuk.bookingfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import pro.gorodnyuk.bookingfriends.api.BookingFriendsRequest;

@Service
@RequiredArgsConstructor
public class BookingFriendsService {

    private final CertificateReceiver certificateReceiver;

    public InputStreamResource reserve(BookingFriendsRequest request) {
        return certificateReceiver.reserve(request);
    }
}
