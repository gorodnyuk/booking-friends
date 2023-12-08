package pro.gorodnyuk.bookingfriends.entity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.gorodnyuk.bookingfriends.entity.BookingFriend;
import pro.gorodnyuk.bookingfriends.web.BookingFriendsRequest;

@Component
public class BookingFriendConverter implements Converter<BookingFriendsRequest, BookingFriend> {

    @Override
    public BookingFriend convert(BookingFriendsRequest request) {
        return BookingFriend.builder()
                .firstName(request.getBookingPerson().getFirstName())
                .lastName(request.getBookingPerson().getLastName())
                .middleName(request.getBookingPerson().getMiddleName())
                .bookingDate(request.getBookingDate())
                .build();
    }
}
