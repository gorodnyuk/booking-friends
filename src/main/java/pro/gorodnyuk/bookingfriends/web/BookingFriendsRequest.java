package pro.gorodnyuk.bookingfriends.web;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class BookingFriendsRequest {

    @Valid
    @NotNull
    private BookingPerson bookingPerson;

    @NotNull
    private LocalDate bookingDate;

    @Data
    public static class BookingPerson {

        @NotBlank
        private String lastName;

        @NotBlank
        private String firstName;

        @NotBlank
        private String middleName;
    }
}
