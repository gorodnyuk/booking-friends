package pro.gorodnyuk.bookingfriends.service;

import pro.gorodnyuk.bookingfriends.dto.Certificate;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

public interface CertificateReceiver {

    Certificate reserve(BookingFriendsRequest request);
}
