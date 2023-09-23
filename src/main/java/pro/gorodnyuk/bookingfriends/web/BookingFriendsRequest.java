package pro.gorodnyuk.bookingfriends.web;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
