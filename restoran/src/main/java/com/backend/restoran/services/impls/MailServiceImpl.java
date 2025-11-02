package com.backend.restoran.services.impls;

import com.backend.restoran.models.ContactMessage;
import com.backend.restoran.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendAutoReply(ContactMessage message) {
        String toUser = message.getEmail();
        String subject = "Təşəkkürlər, " + message.getName() + "!";
        String body = """
                Hörmətli %s,

                Mesajınız uğurla qəbul olundu. Komandamız ən qısa zamanda sizinlə əlaqə saxlayacaq.

                Mövzu: %s
                Mesajınız:
                %s

                Hörmətlə,
                La Taste Restoran komandası
                """.formatted(message.getName(), message.getSubject(), message.getMessage());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toUser);
        mail.setSubject(subject);
        mail.setText(body);
        mailSender.send(mail);
    }
}
