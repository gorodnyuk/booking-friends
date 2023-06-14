package pro.gorodnyuk.bookingfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

import java.io.ByteArrayInputStream;

@Service
@RequiredArgsConstructor
public class BookingFriendsService {

    private final CertificateReceiver certificateReceiver;

    public InputStreamResource reserve(BookingFriendsRequest request) {
        return new InputStreamResource(
                new ByteArrayInputStream(certificateReceiver.reserve(request))
        );
    }
}
