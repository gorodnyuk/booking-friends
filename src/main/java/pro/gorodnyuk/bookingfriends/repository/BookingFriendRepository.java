package pro.gorodnyuk.bookingfriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.gorodnyuk.bookingfriends.entity.BookingFriend;

public interface BookingFriendRepository extends JpaRepository<BookingFriend, Long> {
}
