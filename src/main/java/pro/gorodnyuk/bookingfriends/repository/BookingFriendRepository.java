package pro.gorodnyuk.bookingfriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.gorodnyuk.bookingfriends.entity.BookingFriends;

public interface BookingFriendRepository extends JpaRepository<BookingFriends, Long> {
}
