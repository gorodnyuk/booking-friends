package pro.gorodnyuk.bookingfriends.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import pro.gorodnyuk.bookingfriends.common.constraint.TodayOrFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class BookingFriendsRequest {

    @Valid
    @NotNull(message = "Booking person must be present")
    @Schema(description = "Бронируемый друг")
    private BookingPerson bookingPerson;

    @NotNull(message = "Booking date must be present")
    @TodayOrFuture(message = "Booking date must be today or future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "На какую дату сгенерировать сертификат", example = "2023-10-10")
    private LocalDate bookingDate;

    @Data
    public static class BookingPerson {

        @NotBlank(message = "Last name must be present")
        @Schema(description = "Фамилия бронируемого друга", example = "Иванов")
        private String lastName;

        @NotBlank(message = "First name must be present")
        @Schema(description = "Имя бронируемого друга", example = "Иван")
        private String firstName;

        @Schema(description = "Отчество бронируемого друга", example = "Иванович")
        private String middleName;

        public void setLastName(String lastName) {
            this.lastName = StringUtils.capitalize(lastName);
        }

        public void setFirstName(String firstName) {
            this.firstName = StringUtils.capitalize(firstName);
        }

        public void setMiddleName(String middleName) {
            this.middleName = StringUtils.capitalize(middleName);
        }
    }
}
