package pro.gorodnyuk.bookingfriends.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Booking Friends API",
                description = "API для генерации и получения сертификата на забронированного друга", version = "1.0.0",
                contact = @Contact(
                        name = "Sergey Gorodnyuk",
                        email = "sergeygorodnyuk@yandex.ru",
                        url = "http://gorodnyuk.ru/"
                )
        )
)
public class SwaggerConfiguration {
}
