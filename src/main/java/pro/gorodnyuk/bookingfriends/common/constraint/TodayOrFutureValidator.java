package pro.gorodnyuk.bookingfriends.common.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;

public class TodayOrFutureValidator implements ConstraintValidator<TodayOrFuture, LocalDate> {

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now(ZoneId.of("Europe/Moscow")).plusDays(1).equals(localDate)
                || LocalDate.now(ZoneId.of("Europe/Moscow")).equals(localDate);
    }
}
