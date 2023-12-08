package pro.gorodnyuk.bookingfriends.entity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.gorodnyuk.bookingfriends.entity.BookingFriends;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

@Component
public class BookingFriendConverter implements Converter<BookingFriendsRequest, BookingFriends> {

    @Override
    public BookingFriends convert(BookingFriendsRequest request) {
        return BookingFriends.builder()
                .firstName(request.getBookingPerson().getFirstName())
                .lastName(request.getBookingPerson().getLastName())
                .middleName(request.getBookingPerson().getMiddleName())
                .bookingDate(request.getBookingDate())
                .build();
    }
}
