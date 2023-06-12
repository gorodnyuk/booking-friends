package pro.gorodnyuk.bookingfriends.service;

import pro.gorodnyuk.bookingfriends.api.BookingFriendsRequest;

public interface CertificateReceiver {

    byte[] reserve(BookingFriendsRequest request);
}
