package pro.gorodnyuk.bookingfriends.service;

import org.springframework.core.io.InputStreamResource;

public interface CertificateReceiver {

    InputStreamResource reserve();
}
