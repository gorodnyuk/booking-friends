package pro.gorodnyuk.bookingfriends.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;

@Component
public class CertificateReceiverImpl implements CertificateReceiver {

    @Override
    public InputStreamResource reserve() {
        throw new RuntimeException("Not implemented yet!");
    }
}
