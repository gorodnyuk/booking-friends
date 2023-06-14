package pro.gorodnyuk.bookingfriends.service;

import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

public interface CertificateReceiver {

    byte[] reserve(BookingFriendsRequest request);
}
