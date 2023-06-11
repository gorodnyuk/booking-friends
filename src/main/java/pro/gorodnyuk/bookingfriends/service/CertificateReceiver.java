package pro.gorodnyuk.bookingfriends.service;

import org.springframework.core.io.InputStreamResource;
import pro.gorodnyuk.bookingfriends.api.BookingFriendsRequest;

public interface CertificateReceiver {

    InputStreamResource reserve(BookingFriendsRequest request);
}
